import java.util.*;

public class RuleEngine {
    private final IncidentResponder responder;
    private final Map<String, Integer> failedLoginCounts = new HashMap<>();

    public RuleEngine(IncidentResponder responder) {
        this.responder = responder;
    }

    public void processEvent(SecurityEvent event) {
        if (event.getType() == EventType.LOGIN_FAILURE) {
            handleFailedLogin(event);
        } else if (event.getType() == EventType.LOGIN_SUCCESS) {
            resetFailures(event);
        }
    }

    private void handleFailedLogin(SecurityEvent event) {
        String key = event.getUsername() + "|" + event.getSourceIp();
        int count = failedLoginCounts.getOrDefault(key, 0) + 1;
        failedLoginCounts.put(key, count);

        if (count >= 5) {
            System.out.println("[ALERT] Possible brute-force attack on user " +
                               event.getUsername() + " from IP " + event.getSourceIp());
            responder.lockUser(event.getUsername());
            responder.blockIp(event.getSourceIp());

            if (event.getEndpointId() != null) {
                responder.quarantineEndpoint(event.getEndpointId());
            }
        }
    }

    private void resetFailures(SecurityEvent event) {
        String key = event.getUsername() + "|" + event.getSourceIp();
        failedLoginCounts.remove(key);
    }
}

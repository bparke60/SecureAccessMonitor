import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        EventLogger logger = new EventLogger();
        IncidentResponder responder = new IncidentResponder();
        RuleEngine ruleEngine = new RuleEngine(responder);

        String username = "bj.parker";
        String ip = "10.0.0.42";
        String endpointId = "laptop-001";

        // Simulate 4 failed logins
        for (int i = 1; i <= 4; i++) {
            SecurityEvent fail = new SecurityEvent(
                LocalDateTime.now(), username, ip, endpointId, EventType.LOGIN_FAILURE);
            logger.log(fail);
            ruleEngine.processEvent(fail);
        }

        // 5th failed login triggers an alert
        SecurityEvent fifthFail = new SecurityEvent(
            LocalDateTime.now(), username, ip, endpointId, EventType.LOGIN_FAILURE);
        logger.log(fifthFail);
        ruleEngine.processEvent(fifthFail);

        // Print final checks
        System.out.println("User locked? " + responder.isUserLocked(username));
        System.out.println("IP blocked? " + responder.isIpBlocked(ip));
        System.out.println("Endpoint quarantined? " + responder.isEndpointQuarantined(endpointId));
    }
}

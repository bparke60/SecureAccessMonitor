import java.util.HashSet;
import java.util.Set;

public class IncidentResponder {
    private Set<String> lockedUsers = new HashSet<>();
    private Set<String> blockedIps = new HashSet<>();
    private Set<String> quarantinedEndpoints = new HashSet<>();

    public void lockUser(String username) {
        lockedUsers.add(username);
        System.out.println("[ACTION] Locked user account: " + username);
    }

    public void blockIp(String ip) {
        blockedIps.add(ip);
        System.out.println("[ACTION] Blocked IP address: " + ip);
    }

    public void quarantineEndpoint(String endpointId) {
        quarantinedEndpoints.add(endpointId);
        System.out.println("[ACTION] Quarantined endpoint: " + endpointId);
    }

    public boolean isUserLocked(String username) {
        return lockedUsers.contains(username);
    }

    public boolean isIpBlocked(String ip) {
        return blockedIps.contains(ip);
    }

    public boolean isEndpointQuarantined(String endpointId) {
        return quarantinedEndpoints.contains(endpointId);
    }
}

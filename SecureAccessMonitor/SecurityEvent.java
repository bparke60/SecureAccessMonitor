import java.time.LocalDateTime;

public class SecurityEvent {
    private LocalDateTime timestamp;
    private String username;
    private String sourceIp;
    private String endpointId;
    private EventType type;

    public SecurityEvent(LocalDateTime timestamp,
                         String username,
                         String sourceIp,
                         String endpointId,
                         EventType type) {
        this.timestamp = timestamp;
        this.username = username;
        this.sourceIp = sourceIp;
        this.endpointId = endpointId;
        this.type = type;
    }

    public LocalDateTime getTimestamp() { return timestamp; }
    public String getUsername() { return username; }
    public String getSourceIp() { return sourceIp; }
    public String getEndpointId() { return endpointId; }
    public EventType getType() { return type; }
}

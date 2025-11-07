public class Endpoint {
    private String id;
    private String hostname;
    private EndpointStatus status;

    public Endpoint(String id, String hostname) {
        this.id = id;
        this.hostname = hostname;
        this.status = EndpointStatus.HEALTHY;
    }

    public String getId() { return id; }
    public String getHostname() { return hostname; }
    public EndpointStatus getStatus() { return status; }

    public void quarantine() {
        this.status = EndpointStatus.QUARANTINED;
    }
}

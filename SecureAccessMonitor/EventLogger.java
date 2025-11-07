import java.util.logging.Logger;

public class EventLogger {
    private static final Logger logger = Logger.getLogger(EventLogger.class.getName());

    public void log(SecurityEvent event) {
        logger.info(() -> String.format(
            "EVENT [%s] user=%s ip=%s endpoint=%s type=%s",
            event.getTimestamp(),
            event.getUsername(),
            event.getSourceIp(),
            event.getEndpointId(),
            event.getType()
        ));
    }
}

# Secure Access Monitor — Java Security Event Simulation

A Java learning project that models login-event monitoring, rule-based detection, and automated incident response. This is a **simulation**, not a production SIEM, SOAR, or EDR product.

## What it demonstrates
- Java classes and domain models for security events and endpoints
- Logging and evaluation of simulated login attempts
- A rule that flags five consecutive failed logins
- Simulated responses: account lock, IP block, and endpoint quarantine
- Docker packaging for repeatable execution

## Project components
- `Main.java`: demonstration entry point
- `EventLogger.java`: records events
- `RuleEngine.java`: evaluates repeated failures
- `IncidentResponder.java`: models response actions
- `SecurityEvent.java`, `EventType.java`: event representations
- `Endpoint.java`, `EndpointStatus.java`: endpoint state
- `Dockerfile`: container build

## Run
Clone the repository and enter the directory containing `Main.java` and the other Java source files. Then:

```bash
javac *.java
java Main
```

If Docker is installed, run `docker build -t secure-access-monitor .` from the directory containing the Dockerfile, then `docker run --rm secure-access-monitor`.

## Demonstration
The example models five consecutive failed sign-in attempts, followed by a brute-force alert and simulated account/IP/endpoint actions. Inspect the console output to trace each decision.

## Limitations and next improvements
All events and responses are simulated; the app does not connect to live identity providers, block network traffic, or quarantine real devices. Potential extensions include unit tests for threshold and reset behavior, JSON event ingestion, configurable rules, and structured logs.

**Author:** Brian Parker | B.S. Artificial Intelligence, UNC Charlotte

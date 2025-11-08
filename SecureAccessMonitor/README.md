# Secure Access Monitor (Java + Docker)

### Overview
Secure Access Monitor is a small Java application that simulates how modern cybersecurity systems detect and respond to suspicious activity.  
It was built to show practical understanding of core concepts like event logging, rule-based detection, and automated response — the same ideas behind SIEM, SOAR, and EDR tools used in real security operations.

### How It Works
- The program logs simulated login events for a user and tracks failed attempts.
- After five consecutive failed logins, it raises an alert for a possible brute-force attack.
- Once triggered, it automatically locks the user account, blocks the IP address, and quarantines the endpoint.
- All actions and events are printed to the console so you can clearly see what’s happening step by step.

### Key Components
| File | Purpose |
|------|----------|
| **Main.java** | Runs the simulation and prints results |
| **EventLogger.java** | Records each login attempt (SIEM-style logging) |
| **RuleEngine.java** | Checks for repeated failures and raises alerts |
| **IncidentResponder.java** | Performs automatic actions (SOAR / EDR behavior) |
| **SecurityEvent.java**, **EventType.java** | Define the event data structure |
| **Endpoint.java**, **EndpointStatus.java** | Represent endpoint devices |
| **Dockerfile** | Containerizes the project for consistent execution |

### Run the Project
#### Run locally
```bash
cd ~/Desktop/SecureAccessMonitor
javac *.java
java Main

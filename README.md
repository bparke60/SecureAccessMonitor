Secure Access Monitor (Java + Docker)

A Java project simulating SIEM/SOAR/EDR workflows — detects repeated login failures and triggers automated incident responses. Built with Docker for portability.

Overview
Secure Access Monitor is a small Java application that simulates how modern cybersecurity systems detect and respond to suspicious activity.
It was built to show practical understanding of core concepts like event logging, rule-based detection, and automated response — the same ideas behind SIEM, SOAR, and EDR tools used in real security operations.
How It Works

The program logs simulated login events for a user and tracks failed attempts.
After five consecutive failed logins, it raises an alert for a possible brute-force attack.
Once triggered, it automatically locks the user account, blocks the IP address, and quarantines the endpoint.
All actions and events are printed to the console so you can clearly see what's happening step by step.

Key Components
FilePurposeMain.javaRuns the simulation and prints resultsEventLogger.javaRecords each login attempt (SIEM-style logging)RuleEngine.javaChecks for repeated failures and raises alertsIncidentResponder.javaPerforms automatic actions (SOAR / EDR behavior)SecurityEvent.java, EventType.javaDefine the event data structureEndpoint.java, EndpointStatus.javaRepresent endpoint devicesDockerfileContainerizes the project for consistent execution
Run the Project
Run locally
cd ~/Desktop/SecureAccessMonitor
javac *.java
java Main
Run with Docker
docker build -t secure-access-monitor .
docker run secure-access-monitor
Expected Output
[ALERT] Possible brute-force attack on user bj.parker from IP 10.0.0.42
[ACTION] Locked user account: bj.parker
[ACTION] Blocked IP address: 10.0.0.42
[ACTION] Quarantined endpoint: laptop-001
User locked? true
IP blocked? true
Endpoint quarantined? true

Now the steps:

Click the pencil/edit icon in the top right of the README page
Press Ctrl+A (or Cmd+A on Mac) to select all the existing text
Delete it
Paste everything above
Scroll down and click Commit changes
Click Commit changes again to confirm

Let me know when you're done and I'll verify it looks right.

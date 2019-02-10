# pizza-servlet
Simple servlet using maven archetype presenting current date.

## Before you start

This example requires Amazon account and IAM role allowing you to use Polly SDK.
Hopefully, I am going to deliver you one during our session.

1. First you need to do to make this example working is setting two environment variables in Windows system.
From the desktop, right click the My Computer icon.
Choose Properties from the context menu.
Click the Advanced tab (Advanced system settings link in Vista).
Click Environment Variables. ...
Set up:

* AWS_ACCESS_KEY_ID
* AWS_SECRET_ACCESS_KEY

## How to run it?

1. Compile sources to target .war file using following command
```
mvn clean package
```
2. Copy `target/current-date-servlet.war` to `TOMCAT\apache-tomcat-9.0.8\webapps` location
3. Go to `http://localhost:8080/current-date-servlet/` using your browser.

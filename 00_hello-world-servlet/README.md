# 00_hello-world-servlet
Simplest version of servlet.

## How to run it?

1. Compile java classes using following command. Note classpath parameter and `servlet-api.jar` library
```
javac -classpath TOMCAT\apache-tomcat-9.0.8\lib\servlet-api.jar HelloWorldServlet.java
```
2. Copy `HelloWorldServlet.class` to `C:\TOMCAT\apache-tomcat-9.0.8\webapps\hello-world-servlet\WEB-INF\classes`
3. Copy `web.xml` to `TOMCAT\apache-tomcat-9.0.8\webapps\hello-world-servlet\WEB-INF\`
4. Assuming your tomcat server is up and running, go to `http://localhost:8080/hello-world-servlet` using your browser.
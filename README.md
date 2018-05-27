# servlet-examples

## Enable tomcat manager

1. Edit following file:
```
C:\TOMCAT\apache-tomcat-9.0.8\conf\tomcat-users.xml
```
2. Add following section:
```
<role rolename="manager-gui"/>
<user username="tomcat" password="tomcat" roles="tomcat,manager-gui"/>
```
3. Start your tomcat by running `startup.sh` or `startup.bat`
4. Verify if manager is available `http://localhost:8080/manager/html`

## 00 hello world servlet

1. Compile java classes using following command. Note classpath parameter and `servlet-api.jar` library
```
javac -classpath C:\TOMCAT\apache-tomcat-9.0.8\lib\servlet-api.jar HelloWorldServlet.java
```
2. Copy `HelloWorldServlet.class` to `C:\TOMCAT\apache-tomcat-9.0.8\webapps\hello-world-servlet\WEB-INF\classes`
3. Copy `web.xml` to `C:\TOMCAT\apache-tomcat-9.0.8\webapps\hello-world-servlet\WEB-INF\`


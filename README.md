# Servlet Examples

## Enable tomcat manager

1. Edit following file:
```
TOMCAT\apache-tomcat-9.0.8\conf\tomcat-users.xml
```
2. Add following section:
```
<role rolename="manager-gui"/>
<user username="tomcat" password="tomcat" roles="tomcat,manager-gui"/>
```
3. Start your tomcat by running `startup.sh` or `startup.bat`
4. Verify if manager is available `http://localhost:8080/manager/html`

## List of examples
1. [Simple hello-world-servlet](00_hello-world-servlet/README.md)
- `/` vs `/hello`
- package example
- ROOT example
2. Maven archetype servlet


# Servlet Examples

[![CodeFactor](https://www.codefactor.io/repository/github/towczare/servlet-examples/badge)](https://www.codefactor.io/repository/github/towczare/servlet-examples)

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
0. [Simple hello-world-servlet](00_hello-world-servlet/README.md)
- `/` vs `/hello`
- package example
- ROOT example

1. [Maven archetype servlet](01_maven-current-date-servlet/README.md)
- creating servlet using archetypes
- take a note how servlet classfile location is defined (no .class/.java extension)

2. [Get parameters servlet example](02_maven-current-date-format-servlet/README.md)
- try play with different date formats
- what if someone pass wrong date format in url?

3. [GET POST example](03_get-post-servlet/README.md)
4. [Annotation config example](04_annotation-config-servlet/README.md)

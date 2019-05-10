# Servlet Examples
[Jest też dostępna polska wersja tutaj](README.pl.md)

[![CodeFactor](https://www.codefactor.io/repository/github/towczare/servlet-sda/badge)](https://www.codefactor.io/repository/github/towczare/servlet-sda)

## Enable tomcat manager

1. Edit following file:
```
TOMCAT\apache-tomcat-9.0.8\conf\tomcat-users.xml
```
2. Add following section:
```
<role rolename="manager-gui"/>
<user username="tomcat" password="tomcat" roles="tomcat,manager-gui,manager-script"/>
```
3. Start your tomcat by running `startup.sh` or `startup.bat`
4. Verify if manager is available `http://localhost:8080/manager/html`
5. Basic auth will require from you user and password, default for this configuration `tomcat/tomcat`
6. You should see following page:
![.images/tomcat_manager.png](.images/tomcat_manager.png)

## Maven configure settings
Paste content of following file `settings.xml` to `Users/USERNAME/.m2` directory (`~/.m2` linux users)
```
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">


<servers>
    <server>
       <id>TOMCAT8</id>
       <username>tomcat</username>
       <password>tomcat</password>
    </server>
</servers>
</settings>
```


## List of modules

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
5. [MVC JSP Servlet](05_mvc-jsp-servlet/README.md)
6. [Filter Servlet](06_filter-servlet/README.md)

## Debuging Tomcat Applications
Easiest way to debug application is running your tomcat with following `jpda` parameter. You can achieve this by providing it to following command:
for linux:
```
./catalina.sh jpda run
```
for windows:
```
catalina.bat jpda run
```
Then in inteliJ idea define remote debug configuration with default jpda port 8000


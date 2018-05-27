# 01_maven-current-date-servlet
Simple servlet using maven archetype presenting current date.

## How to run it?

1. Compile sources to target .war file using following command
```
mvn clean package
```
2. Copy `target/current-date-servlet.war` to `TOMCAT\apache-tomcat-9.0.8\webapps` location
3. Go to `http://localhost:8080/current-date-servlet/` using your browser.


## How to create new servlet using archetype?

- https://maven.apache.org/plugins-archives/maven-archetype-plugin-1.0-alpha-7/examples/webapp.html
- https://www.mkyong.com/maven/how-to-create-a-web-application-project-with-maven/

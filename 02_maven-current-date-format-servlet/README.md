# 02_maven-current-date-format-servlet
Simple servlet using maven archetype presenting current date in different formats.

## How to run it?

1. Compile sources to target .war file using following command
```
mvn clean package
```
2. Copy `target/current-date-servlet.war` to `TOMCAT\apache-tomcat-9.0.8\webapps` location
3. Go to `http://localhost:8080/current-date-servlet/` using your browser.
4. Additional feature is available by providing `?format=` parameter.


## How to create new servlet using archetype?

- https://maven.apache.org/plugins-archives/maven-archetype-plugin-1.0-alpha-7/examples/webapp.html
- https://www.mkyong.com/maven/how-to-create-a-web-application-project-with-maven/

## Exercises

*Exercise 02:*
Remember `random-animal-servlet` Try to implement feature allowing to filter to given type animal for example:

For given path `http://localhost:8080/random-animal-servlet/next?type=bird` you should get:
- chicken
- owl
...
and for path `http://localhost:8080/random-animal-servlet/next?type=insect` you should get:
- ant
- worm
...
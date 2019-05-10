# 00_hello-world-servlet

[This file is translated version of original file available here](README.md)

Najprostszy servlet świata.

## :gear: Jak to odpalić?

1. Skompiluj klasy java używając polecenia poniżej. Zwróć uwagę na parametr wskazujący lokalizację biblioteki `servlet-api.jar`
```
javac -classpath TOMCAT\apache-tomcat-9.0.8\lib\servlet-api.jar HelloWorldServlet.java
```
2. Skopiuj `HelloWorldServlet.class` do `C:\TOMCAT\apache-tomcat-9.0.8\webapps\hello-world-servlet\WEB-INF\classes` (twoja lokalizacja)
3. Skopiuj `web.xml` do `TOMCAT\apache-tomcat-9.0.8\webapps\hello-world-servlet\WEB-INF\`
4. Zakładając, że twój serwer jest uruchomiony, otwórz przeglądarkę z adresem `http://localhost:8080/hello-world-servlet`
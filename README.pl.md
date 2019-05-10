# Servlet Examples

[This file is translated version of original file available here](README.md)

[![CodeFactor](https://www.codefactor.io/repository/github/towczare/servlet-sda/badge)](https://www.codefactor.io/repository/github/towczare/servlet-sda)

## Włączamy manager Tomcat

1. Edytuj ten plik:
```
TOMCAT\apache-tomcat-9.0.8\conf\tomcat-users.xml
```
2. Dodaj następującą sekcję:
```
<role rolename="manager-gui"/>
<user username="tomcat" password="tomcat" roles="tomcat,manager-gui,manager-script"/>
```
3. Uruchom Tomcata przy użyciu `startup.sh` lub `startup.bat`
4. Zweryfikuj, że manager jest dostępny `http://localhost:8080/manager/html`
5. Zostaniesz poproszony o hasło któe podałeś w konfiguracji, domyślne `tomcat/tomcat`
6. Powinieneś zobaczyć okno podobne do poniższego:
![.images//tomcat_manager.png](.images/tomcat_manager.png)

## Konfiguracja ustawień mavena
1. Wklej poniższą treść do pliku `settings.xml` zlokalizowanego w folderze `Users/USERNAME/.m2` (`~/.m2` użytkownicy linuxa lub maca)
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

## Lista modułów

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
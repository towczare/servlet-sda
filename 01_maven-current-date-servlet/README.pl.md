# 01_maven-current-date-servlet

[This file is translated version of original file available here](README.md)

Prosty servlet mavenowy, prezentujący aktualną datę.

## :gear: Jak to odpalić?

1. Skompiluj swoje źródła do pliku wynikowego .war który zostanie utworzony w folderze target używając poniżej komendy lub IDE
```
mvn clean package
```
2. Skopiuj `target/current-date-servlet.war` do lokalizacji `TOMCAT\apache-tomcat-9.0.8\webapps`
3. Przejdź do `http://localhost:8080/current-date-servlet/` używając swojej przeglądarki.


## :thinking: Jak stworzyć swój własny servlet przy pomocy archetypu mavenowego?

- https://maven.apache.org/plugins-archives/maven-archetype-plugin-1.0-alpha-7/examples/webapp.html
- https://www.mkyong.com/maven/how-to-create-a-web-application-project-with-maven/

## Zadania

*Zadanie 01:*
Spróbuj zaimplementować podobny servlet o nazwie `random-animal-servlet`

Twój nowy servlet powinien pozwolić na wyświetlenie losowego zwierzaka z listy ilekroć użytkownik odświeży przeglądarkę:
* `http://localhost:8080/random-animal-servlet/next`

Jako przechowalnię swoich zwierzaków użyj zwykłej implementacji listy `List<Animal>`
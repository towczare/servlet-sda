# 02_maven-current-date-format-servlet

[This file is translated version of original file available here](README.md)

Prosty servlet pozwalający na prezentowanie daty w różnych formatach.

## :gear: Jak to odpalić?

1. Skompiluj źródła do pliku .war używając komendy lub swojego IDE
```
mvn clean package
```
2. Skopiuj `target/current-date-servlet.war` do `TOMCAT\apache-tomcat-9.0.8\webapps`
3. Otwórz przeglądarkę `http://localhost:8080/current-date-servlet/`
4. DOdatkową funkcjonalnością w stosunku do zadania pierwszego, jest możliwość podania formatu, przy użyciu parametru GET `?format=`

## :thinking: Jak stworzyć swój własny servlet przy pomocy archetypu mavenowego?

- https://maven.apache.org/plugins-archives/maven-archetype-plugin-1.0-alpha-7/examples/webapp.html
- https://www.mkyong.com/maven/how-to-create-a-web-application-project-with-maven/

## Zadania

*Zadanie 02:*
Pamiętasz swój `random-animal-servlet` stworzony w ramach poprzedniego zadania? Spróbuj zaimplementować ficzer pozwalający na odfiltrowywanie zwierząt do danego typu np:

Dla następującego parametry `http://localhost:8080/random-animal-servlet/next?type=bird` powinniśmy dostać jako rezulat:
- chicken
- owl
...
zaś dla następującego adresu `http://localhost:8080/random-animal-servlet/next?type=insect`:
- ant
- worm
...
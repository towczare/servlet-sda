# 05_mvc-jsp-servlet

[This file is translated version of original file available here](README.md)

Prosty servlet pokazujący połączenie technologii jsp i servletów

## Zadania
*Zadanie 05:*
1. Stwórz następująca klasę reprezentującą model zwierza animal:
```
Animal {
    String id; (autogenerowane podczas tworzenia zwierza)
    enum Species {FISH, MAMMALS, REPTILE, INSECT, BIRD, AMPHIBIAN}
    String name;
    int age;
    String pictureUrl;
    String description;
}
```
2. Stwórz mapę `Map<Integer, Animal>` która posłuży nam do przechowywania naszych zwierzaków. Jako klucz będziemy w niej trzymać identyfikator zierza. Taki zabieg często określany jest mockowaniem źródła danych.
3. Zaimplementuj widok pozwalający naszemu servletowi na zaprezentowanie wszystkich zwierząt (może być to tabelka, lista lub cokolwiek prefereujesz)
Przykładowy widok powinien prezentować coś podobnego do:

| Imie            | Wiek          |Gatunek  |
| ----------------|:-------------:| -------:|
| Cat Sylvester   |12             | Ssak    |
| Doge            |1              | Ssak    |
| Turtle Leonardo |101            | Gad     |

4. Teraz zaimplementuj analogiczny widok szczegółowy prezentujący więcej danych zwierza, np:
- Id: 1
- Imie: Cat Sylvester
- Wiek: 12
- Gatunek: Ssak
![Jakieś ładne zdjęcie kotka](http://images5.fanpop.com/image/photos/30900000/Sylvester-the-Cat-warner-brothers-animation-30976217-250-262.jpg "ładne zdjęcie kotka")
```
ot Sylwester – postać fikcyjna, antropomorficzny kot, bohater ponad 90 odcinków Zwariowanych melodii, kreskówek tworzonych w latach 1945–1966. Tematyką większości odcinków z jego udziałem były gonitwy za ptaszkiem Tweetym lub Speedym Gonzalesem. Imię "Sylwester" (ang. Sylvester) pochodzi od łacińskiej nazwy gatunkowej żbika (silvestris, łac. las). Sylwester zadebiutował w kreskówce Friza Frelenga Życie lekkie jak piórko (1945). W innym filmie Frelenga, Łakomy kąsek (1946), po raz pierwszy wystąpił razem z Tweetym, zaś w wyreżyserowanym przez Chucka Jonesa Przestraszyć kota (1948) z Prosiakiem Porkym.

Charakterystyczną cechą Sylwestra jest jego wada wymowy. Jego głos był wzorowany na głosie Kaczora Daffy’ego (który miał być z kolei zainspirowany przez głos producenta Leona Schlesingera). Dubbingujący kota Mel Blanc twierdził, iż głos Sylwestra jest podobny do jego własnego. Później dubbingował go Joe Alaskey, a w polskiej wersji dubbingowej głosu użycza mu Włodzimierz Press.

Sylwester jest dumnym kotem i nigdy się nie poddaje. Mimo tego przeważnie znajduje się on po przegranej stronie w starciach z oponentami. Jego postać jest oparta na Kojocie Wilusiu, przy czym Sylwester poluje na myszy lub drobne ptaki (obie postacie spotkały się w jednym z odcinków, w którym wspólnie polowały na biorących udział w wyścigu Strusia Pędziwiatra i Speedy’ego Gonzalesa). Czasem zdarzało się, że jego postać ukazywana była od innej strony, m.in. gdy wraz z Porkym przebywał w nawiedzonych miejscach (odgrywał wtedy rolę przerażonego kota). Najbardziej rozwinięte role miał w krótkometrażówkach Roberta McKimsona, w których próbował nauczyć łapania myszy swojego syna, Sylwestra Juniora (wtedy funkcję "myszy" pełniło potężne kangurzątko).
```
5. Następnym krokiem to przygotowanie widoku formularza pozwalającego na dodanie nowych zwierzaków do naszej mapy Map<Integer, Animal>, która pełni tutaj rolę naszej bazy danych.
:bulb: W tym celu stwórz formularz z akcją kierującą na servlet z obsługą akcji `doPost`, następnie zaimplementuj całą logikę.
6. Dodajmy obsługę usuwania naszego zwierzaka. Powinien to być specjalny url przymujący rządania POST, pozwalające na wysłanie identyfikator zwierzaka, które chcemy usunąć.
7. Dalszy krok to funkcjonalność pozwalająca na edycję zwierzaka
:bulb: W tym celu zastanów się czy nie mógłbyś wykorzystać istniejący formularz dodawania zwierzaka, dodając do niego lekkie modyfikacje.
## Gratulacje, właśnie ukończyłeś swój pierwszy projekt [CRUD](https://pl.wikipedia.org/wiki/CRUD) :sunglasses:

Teraz moment na zastanowienie się nad własnym projektem, jak mógłbyś użyć technik tutaj poznanych do zrealizowania swojego własnego pomysłu.

8. Dodaj więcej zwierzaków do mapy Map<Integer, Animal>, np. 20. Teraz przygotuj filtr powyżej swojego widoku listy, którym będziesz w stanie odfiltrowywać zwierzęta po:
* imieniu
* gatunku
* wieku
:bulb: Lepszą metodą http w tym wypadku będzię metoda GET, dzięki czemu będziesz w stanie skopiować url i przekazać odfiltrowaną listę zwierzaków
9. Dalszy rozwój aplikacji powinien zawierać możliwość paginacji zwierząt. Póki jest ich kilka nie stanowią problemu, ale pomyśl, o sytuacji w której nasza baza będzie zawierała tysiące zwierząt.
```
?page=1&delta=20
```
- page - reprezentuje numer strony którą chcielibyśmy zwrócić
- delta - reprezentuje ilość elementów, którą powinna zawierać pojedyncza strona



## :thinking: Jak zbudować swój własny CRUD
1. Podziel aplikacje na warstwy model/controller/service
      ```
      foo
      └── bar
          └── yourdomain
              ├── controller
              ├── model
              └── service
      ```
2. Implement simple routing in `YourServlet.java` and put it in your controller package
2. Zaimplementuj prosty routing w swoim servlecie `YourServlet.java` i umieść go w swoim pakiete kontrollera.
    - `/` -> `list.jsp`
    - `/details` -> `details.jsp`
    - `/add` -> `form.jsp`
   W każdej z powyższych stron, póki co dodajmy prosty nagłówek, który pokaże nam czy znajdujemy się na tej stronie o którę prosiliśmy:
   ```
   <h1> Welcome on list.jsp</h1>
   <h1> Welcome on details.jsp</h1>
   ...
   ``` 
3. Dodaj model klasy do swojego projektu `YourModel.java` do pakietu `foo.bar.yourdomain.model`
4. Create `YourService.java` storing static `List<YourModel> YOUR_MODELS`
4. Stwórz klasę serwisową `YourService.java` przechowującą statyczną listę `List<YourModel> twoich modelów`
5. Uzupełni listę `YOUR_MODELS` kilkoma przykładowymi wartościami.
:bulb: Możesz to zrealizować np bloku statycznym:
```
static {
...
}
```
6. Zaimplementuj metodę w `YourService.java` o nazwie `List<YourModel> findAll()` pozwalającą na zwrócenie całej listy.
:bulb: W przyszłości ta metoda może zostać w bardzo prosty sposób zastąpiona realnym dostępem do bazy.
7. Spróbuj użyć tej metody `YourService.findAll()` w `YourServlet.java` i przekazać jej wynik w następujący sposób:
 ```
 request.setAttribute("yourList", yourService.findAll());
 ```
8. Na początek spróbujmy sprawdzić na widoku, czy przekazana lista posiada taką samą ilość elementów co statyczna lista w serwisie:
```
<h3>${yourList.size()}</h3>
```
9. Teraz możemy skupić się na wyświetleniu elementów w `list.jsp` używając poznanych wcześniej tagó JSTL (sprawdź przykłady w [`jsp-example`](https://github.com/towczare/jsp-sda/tree/master/09_jstl-jsp))
Pamiętaj o dodaniu zależności do swojego `pom.xml`:
```
<dependency>
  <groupId>jstl</groupId>
  <artifactId>jstl</artifactId>
  <version>1.2</version>
</dependency>
```
10. Dodaj autogenerowanie id do swojego modelu `YouModel.java` w konstruktorze aby każdy z obiektów dostał unikalny identyfikator:
```
UUID.randomUUID().toString()
```
lub zaimplementuj prosty zliczacz, któy będzie podbijał swoją wartość ilekroć zostanie wywołany podczas tworzenia nowego obiektu:
```
static Integer CURRENT_INDEX = 1;
```
Now in YourModel(...) constructor class use `CURRENT_INDEX` value and increment it for next object `++`

11. Spróbuj zaimplementować obsługę parametru w swojej metodzie `doGet(...)` w klasie `YourServlet.java`
Sprawdź przykład `03_get-post-servlet` jeśli nie pamiętasz jak to robiliśmy.
12. Zaimplementuj w swoim serwisie `YourService.java` metodę `YourModel findOne(String id)` która będzie zwracała dokłądny obiekt o identyfikatorze, który podaliśmy jako parametr.
13. Przekaż pozyskany obiekt przy użyciu tej metody do widoku `details.jsp` i spróbuj go wyświetlić przy użyciu odpowiedniej mieszanki tagów html i JSTL
14. Stwórz formularz pozwalający na utworzenie nowej nazwy obiektu który tworzesz. Po raz kolejny możesz posłużyć się przykładem któy przerabialiśmy wcześniej.
15. Zaimplementuj metodę `doPost` która utworzy nową instancję twojego modelu `YourModel` i przekaże go do nowej metody `add(YourModel newModel)` w twoim serwisie `YourService`
16. Na sam koniec powinniśmy przekierować użytkownika na stronę listy `/` Uzyj przykładu opisanego w `03_get-post-servlet` jako referencja.

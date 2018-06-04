# 05_mvc-jsp-servlet
Simple portlet showing combining jsp technology with servlet controller


## Exercises

*Exercise 05:*
1. Create model for animal:
```
Animal {
    Integer id;
    enum Species {FISH, MAMMALS, REPTILE, INSECT, BIRD, AMPHIBIAN}
    String name;
    int age;
    String pictureUrl;
    String description;
}
```
2. Create `Map<Integer, Animal>` storing some animals, where key is their id. This will mock your datasource.
3. Implement view of servlet allowing you to see all animals (you can use table, list or anything you like)
Here is example of this view:

| Name            | Age           |Species  |
| ----------------|:-------------:| -------:|
| Cat Sylvester   |12             | Mammal  |
| Doge            |1              | Mammal  |
| Turtle Leonardo |101            | Reptile |

4. Implement details view, allowing you to see details of animal
```
Id: 1
Name: Cat Sylvester
Age: 12
Species Mammal
![some pretty picture of cat](https://upload.wikimedia.org/wikipedia/en/thumb/8/82/Sylvester_the_Cat.svg/1200px-Sylvester_the_Cat.svg.png "some pretty picture of cat")
Sylvester J. Pussycat Sr., usually called Sylvester, is a fictional character, a three-time Academy Award-winning anthropomorphic, 40, 50, or 60-Inch tall Tuxedo cat in the Looney Tunes and Merrie Melodies series of cartoons.[1] Most of his appearances have him often chasing Tweety Bird, Speedy Gonzales, or Hippety Hopper. The name "Sylvester" is a play on Felis silvestris, the scientific name for the wild cat species (domestic cats like Sylvester, though, are actually Felis catus). The character debuted in Friz Freleng's Life With Feathers (1945), but Freleng's 1947 cartoon Tweetie Pie was the first pairing of Tweety with Sylvester, and the Bob Clampett-directed Kitty Kornered (1946) was Sylvester's first pairing with Porky Pig. Sylvester was not named until Chuck Jones gave him the name Sylvester, which was first used in Scaredy Cat.[citation needed] Sylvester appeared in 103 cartoons in the golden age, appearing in the fourth most films out of all the Looney Tunes/Merrie Melodies characters, only behind Bugs Bunny, Porky Pig, and Daffy Duck respectively. Three of his cartoons won Academy Awards, the most for any starring Looney Tunes character: they are Tweetie Pie, Speedy Gonzales, and Birds Anonymous.
```
5. Next step is preparing form allowing you to add new animals to Map<> representing you database.
6. Implement feature allowing you to delete animals, and include url which allows you to POST request.
7. Implement feature allowing you to edit given animal and save results.
## Congratulations you completed your first CRUD project :-)
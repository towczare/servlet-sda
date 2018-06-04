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
<some pretty image of cat Sylvester>
Lorem ipsum... description of cat...
```
5. Next step is preparing form allowing you to add new animals to Map<> representing you database.
6. Implement feature allowing you to delete animals, and include url which allows you to POST request.
7. Implement feature allowing you to edit given animal and save results.
## Congratulations you completed your first CRUD project :-)
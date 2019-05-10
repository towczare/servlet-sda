# 03_get-post-servlet

[Jest też dostępna polska wersja tutaj](README.pl.md)

Simple servlet using maven archetype covering GET POST methods


## Exercises

*Exercise 03:*
Remember `random-animal-servlet` We are going to develop new features to this servlet.

1. Move feature of getting random animal to `/random` context path
2. Default endpoint GET `/` should return whole list of animals (at the moment you can use simple iteration over List with toString method called on Animal object)
3. POST `/` should allow to add new animal to list and redirect user to GET `/` endpoint.
:bulb: One of the following tools might be useful `POSTMAN`, `INSOMNIA` or `curl` in this exercise


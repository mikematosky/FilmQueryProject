# Film Query Project

## About Film Query
This is a user interface that interacts with a local database consisting of **movies** and **actors**.

The interface allows for 2 user options:
1. **Search Movie by Movie ID#**- where a user can input an integer and pull up a movie and
it's information including *Title*, *Release Year*, *Parental Rating*, *Language*,
*Plot Description*, and a list of all the *Actors* from the cast.
2. **Search Movie by Keyword**- where a user can input a word and search all *Titles* and
*Descriptions* and return all movies that match with that keyword.

## File List

1. *Entity* **Actor**- This class contains the *Actor* object with fields including an ID# and
first and last names. There is room to create a list of movies they were in as a requirement
creep.
2. *Entity* **Film** This class contains the *Film* object with fields including ID#, title,
parental rating, language, description, a list of the Actors appearing in the film, the length,
the rental period (Blockbusters used to allow you to only rent new releases for a shorter time),
the replacement cost if something happened to the physical copy, the rental price, and an
optional special features section.
3. *Database* **DatabaseAccessor**- An interface for the DatabaseAccessorObject.
4. *Database* **DatabaseAccessorObject**- An object for interacting and retrieving information
from a local database. This object contains the queries we interact with the local database with.
5. *Application* **FilmQueryApp**- The application with the main. It creates the
DatabaseAccessorObjects and creates and follows the menu created for the user story.

## Notes
- I could definitely use a JOIN statement to get the language from the language_id, but
it was getting crowded enough. If this is a sticking point, I could then populate the language
with language.name if joined by the language_id from the film.
- Creating the next stretch goal would be using labels to break back to the Menu from the subMenu
that pops up after the initial selection.
- I don't know the approved convention of manipulating the toString() overrides. I chose
to beautify my code by using the toString() method rather than creating a separate print method.
- The search for "happy" returns 0 movies from descriptions and titles. There are no happy movies.

## Hindsight / Lessons / What I Learned / Reflections
- It was important to do my own design based on the full picture of the user stories to ensure
I had the proper fields, methods, overrides, and hashcode.



# Lessons Learned and Reinforced
+ Incorporating mySQL Queries into a Java Application
+ Connecting to a local SQL Database
+ Reinforced OOP principles (APIE)
+ Java- Try/Catch with Resources
+ Maven Dependencies
+ Java- Interface
+ JUnit5 testing
+ Java- Labels


# Technology Used
* Eclipse
* Terminal
* Git
* Atom
* JUnit5
* MAMP
* mySQL
* Maven

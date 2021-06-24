# Pokedex
Simple application that provides endpoints to manage pokemons. It is storing data in H2 database. To run program simply clicking run in your IDE or run command "mvn spring-boot:run" from terminal or from Command Prompt.

# REST API

The REST API is described below.

`GET /getAll

Return list of all elemnets in pages of 5 elements.

`GET /getbyID/{id}

Return element with that id.

`GET /Delete/{id}

Removes element with that id from database.

`POST /Add/{name}/{type}/{description}

Adds element to database with auto generated id.

`POST /Update/{id}/{name}/{type}/{description}

Update element with that id.

`GET /getbyName/{name}

Search element by ID and return it

`GET //getbyType/{type}/{page}

Search elements by Type and returns them.
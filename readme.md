# Movie Lab REST API

#### A sample Movie Lab project created using Spring Boot, Reactive Mongo DB and WebFlux 

### Requirements
- Java 11
- Spring Boot 2.5.4
- Spring Webflux
- Spring Reactive Data MongoDb

### Steps

#### 1. Clone the application

```
https://github.com/narzullaev/pixily.git
```

#### 2. Build and run the app using gradle 

```
./gradlew bootRun
```

The server will start at http://localhost:8080

## Exploring the Rest APIs

The application defines following REST APIs

```
1. GET /movies - Get All Movies

2. POST /movies - Create a new Movie

3. GET /movies/{id} - Retrieve a Movie by Id

3. PUT /tweets - Update a Movie

4. GET /movies/movie/{title} - Retrive a Movie by Title

5. DELETE /movies/{id} - Delete a Movie
```

## Running integration tests
#### For running the integration tests, go to the root directory of the project and type ```gradlew clean test --info``` in your terminal.

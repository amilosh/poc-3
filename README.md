# poc-3
Proof of concept project

## Tools
- Java 17
- Maven 3.9.6
- Spring Boot 3.2.2
- MongoDB 7.0.5

## Run

```
docker pull mongo:7.0.5
docker run -d --name product-service -p 27017:27017 -e MONGO_INITDB_DATABASE=product-service mongo:7.0.5
```
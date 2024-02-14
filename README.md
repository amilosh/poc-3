# poc-3
Proof of concept project

# product-service

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

# order-service

## Tools
- Java 17
- Maven 3.9.6
- Spring Boot 3.2.2
- MyQL 8.3

## Run

```
docker pull mysql:8.3
docker run -d --name order-service -p 3307:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=order-service mysql:8.3
```


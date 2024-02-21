# poc-3
Proof of concept project

# all-services
### Tools
- Java 17
- Maven 3.9.6
- Spring Boot 3.2.2
- Spring Cloud 2023.0.0 (Eureka)

### Features
- Spring WebFlux, WebClient
- Random ports, multi-instances, load balancer
- Spring Cloud Eureka discovery service
- Spring Cloud Eureka clients
- Spring Cloud Api Gateway

# discovery-server
### Run
```
http://localhost:8761
```

# product-service
### Tools
- MongoDB 7.0.5
### Run
```
docker pull mongo:7.0.5
docker run -d --name product-service -p 27017:27017 -e MONGO_INITDB_DATABASE=product-service mongo:7.0.5

http://localhost:8080
```

# order-service
### Tools
- MyQL 8.3
### Run
```
docker pull mysql:8.3
docker run -d --name poc-3-mysql -p 3307:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=order_service mysql:8.3

http://localhost:8081
```

# inventory-service
### Tools
- MyQL 8.3
### Run
```
docker exec -it {containerId} bash
mysql -u root -proot

CREATE DATABASE inventory_service;

http://localhost:{randomPPort}
```

# interactions
order-service -> inventory-service: WebClient
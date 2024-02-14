package pl.amilosh.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.amilosh.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}

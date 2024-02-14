package pl.amilosh.productservice.service;

import pl.amilosh.productservice.dto.ProductDto;

import java.util.List;

public interface ProductService {

    void createProduct(ProductDto productDto);

    List<ProductDto> getAllProducts();
}

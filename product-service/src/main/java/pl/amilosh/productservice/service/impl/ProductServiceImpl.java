package pl.amilosh.productservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.amilosh.productservice.dto.ProductDto;
import pl.amilosh.productservice.mapping.ProductMapper;
import pl.amilosh.productservice.repository.ProductRepository;
import pl.amilosh.productservice.service.ProductService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public void createProduct(ProductDto productDto) {
        var product = productMapper.toEntity(productDto);
        productRepository.save(product);
        log.info("Product {} was successfully saved", product.getId());
    }

    @Override
    public List<ProductDto> getAllProducts() {
        var products = productRepository.findAll();
        return productMapper.toDtos(products);
    }
}

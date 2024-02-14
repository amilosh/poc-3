package pl.amilosh.productservice.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import pl.amilosh.productservice.dto.ProductDto;
import pl.amilosh.productservice.repository.ProductRepository;

import java.math.BigDecimal;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class AbstractIntegrationTest {

    private static final String DEFAULT_PRODUCT_NAME = "Product name";
    private static final String DEFAULT_PRODUCT_DESCRIPTION = "Product description";
    private static final BigDecimal DEFAULT_PRODUCT_PRICE = new BigDecimal("999.99");

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected ProductRepository productRepository;

    @Container
    protected static final MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:7.0.5"));

    @DynamicPropertySource
    protected static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    protected ProductDto createDefaultProductDto() {
        return ProductDto.builder()
            .name(DEFAULT_PRODUCT_NAME)
            .description(DEFAULT_PRODUCT_DESCRIPTION)
            .price(DEFAULT_PRODUCT_PRICE)
            .build();
    }

    protected ProductDto createProductDto(String name, String description, BigDecimal price) {
        return ProductDto.builder()
            .name(name)
            .description(description)
            .price(price)
            .build();
    }
}

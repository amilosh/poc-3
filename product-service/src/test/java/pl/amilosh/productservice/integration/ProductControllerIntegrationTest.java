package pl.amilosh.productservice.integration;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductControllerIntegrationTest extends AbstractIntegrationTest {

    @Test
    public void testCreateProduct() throws Exception {
        var productDto = createDefaultProductDto();
        var productDtoJson = objectMapper.writeValueAsString(productDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/product")
            .contentType(APPLICATION_JSON)
            .content(productDtoJson)).andExpect(status().isCreated());

        assertEquals(1, productRepository.findAll().size());
    }
}

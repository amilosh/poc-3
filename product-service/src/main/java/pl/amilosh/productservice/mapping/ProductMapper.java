package pl.amilosh.productservice.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.amilosh.productservice.dto.ProductDto;
import pl.amilosh.productservice.model.Product;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    Product toEntity(ProductDto productDto);

    ProductDto toDto(Product product);

    List<ProductDto> toDtos(List<Product> products);
}

package com.diemdt.trainingT4.mapper;

import com.diemdt.trainingT4.dto.ProductDTO;
import com.diemdt.trainingT4.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDTO toDTO(Product product);

    @Mapping(target = "category.id", source = "categoryId")
    Product toEntity(ProductDTO productDTO);
}

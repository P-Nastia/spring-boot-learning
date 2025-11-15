package org.example.mappers;

import org.example.data.dtos.product.CategoryCreateDTO;
import org.example.data.dtos.product.CategoryItemDTO;
import org.example.data.seed.CategorySeed;
import org.example.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "image", ignore = true)
    CategoryEntity toEntity(CategorySeed category);

    CategoryItemDTO toDto(CategoryEntity category);

    CategoryEntity fromCreateDTO(CategoryCreateDTO dto);
}

package com.example.ananas.mapper;

import org.mapstruct.Mapper;

import com.example.ananas.dto.response.CategoryResponse;
import com.example.ananas.entity.Category;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {
    CategoryResponse toCategoryResponse(Category category);
}

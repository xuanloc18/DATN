package com.example.ananas.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.ananas.dto.response.ProductImagesResponse;
import com.example.ananas.entity.Product_Image;

@Mapper(componentModel = "spring")
public interface IProductImageMapper {
    @Mapping(source = "imageUrl", target = "imageUrl")
    @Mapping(source = "product.productId", target = "productId")
    @Mapping(source = "id", target = "id")
    ProductImagesResponse toProductImagesResponse(Product_Image productImage);

    List<ProductImagesResponse> toProductImagesResponseList(List<Product_Image> productImageList);
}

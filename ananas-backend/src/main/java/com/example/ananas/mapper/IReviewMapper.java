package com.example.ananas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.example.ananas.dto.ReviewDTO;
import com.example.ananas.dto.response.ReviewResponse;
import com.example.ananas.entity.Review;

@Mapper(componentModel = "spring")
public interface IReviewMapper {
    Review toReview(ReviewDTO reviewDTO);

    ReviewDTO toReviewDTO(Review review);

    ReviewResponse toReviewResponse(Review review);

    void updateReview(@MappingTarget Review review, ReviewDTO reviewDTO);
}

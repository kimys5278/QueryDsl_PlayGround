package com.springboot.qeurydsl_prac.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductResponseDto {
    private String name;
    private String price;
    private String category;

    @Builder
    public ProductResponseDto(String name, String price, String category){
        this.name = name;
        this.price = price;
        this.category = category;

    }

}

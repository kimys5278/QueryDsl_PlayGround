package com.springboot.qeurydsl_prac.service;

import com.springboot.qeurydsl_prac.dto.ProductResponseDto;
import com.springboot.qeurydsl_prac.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getProductList(String category);
    List<ProductResponseDto> getProductListWithPage(int page, int size);
    List<ProductResponseDto> getProductListWithPageAndSortPriceDesc(int page, int size);


}

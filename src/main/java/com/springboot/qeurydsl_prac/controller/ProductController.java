package com.springboot.qeurydsl_prac.controller;

import com.springboot.qeurydsl_prac.dto.ProductResponseDto;
import com.springboot.qeurydsl_prac.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nullable;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/v1/product")
    public List<ProductResponseDto> getProductList( @RequestParam("category") String category){
        return productService.getProductList(category);

    }
    @GetMapping("/v2/product")
    public List<ProductResponseDto> getProductListWithPage(@RequestParam("page") int page,
                                                           @RequestParam("size") int size) {

        // 페이징 처리 1: 정렬 기준없이, 쌓인 데이터 순서대로 페이징 처리
        return productService.getProductListWithPage(page, size);
    }

    @GetMapping("/v3/product")
    public List<ProductResponseDto> getProductListWithPageAndSortPriceDesc(@RequestParam("page") int page,
                                                                           @RequestParam("size") int size) {

        // 페이징 처리 2: 가격 기준 내림차순 정렬된 데이터에 대한 페이징 처리
        return productService.getProductListWithPageAndSortPriceDesc(page, size);
    }

}

package com.springboot.qeurydsl_prac.service.Impl;

import com.springboot.qeurydsl_prac.dto.ProductResponseDto;
import com.springboot.qeurydsl_prac.entity.User;
import com.springboot.qeurydsl_prac.repository.product.ProductRepository;
import com.springboot.qeurydsl_prac.service.ProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    // 1. category가 없을땐, 전체 조회
    // 2. categoryr가 있을땐, 해당 카테고리만 조회.

    @Override
    public List<ProductResponseDto> getProductList(String category){
       List<ProductResponseDto> responseDtos = null;
      //전체조회
       if(Objects.isNull(category)){
           productRepository.findAll().stream()
                   .map(m ->
                           ProductResponseDto.builder()
                                   .name(m.getName())
                                   .price(String.valueOf(m.getPrice()))
                                   .category(m.getCategory())
                                   .build())
                   .collect(Collectors.toList());
       }else{
           responseDtos = productRepository.getProductList(category).stream()
                   .map(m->
                           ProductResponseDto.builder()
                                   .name(m.getName())
                                   .price(String.valueOf(m.getPrice()))
                                   .category(m.getCategory())
                                   .build())
                   .collect(Collectors.toList());
       }

        return responseDtos;
    }

    @Override
    public List<ProductResponseDto> getProductListWithPage(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page,size);

        return productRepository.getProductListWithPage(pageRequest.getOffset(),pageRequest.getPageSize())
                .stream()
                .map(m ->
                        ProductResponseDto.builder()
                                .name(m.getName())
                                .price(String.valueOf(m.getPrice()))
                                .category(m.getCategory())
                                .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDto> getProductListWithPageAndSortPriceDesc(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return productRepository.getProductListWithPageAndSortPriceDesc(pageRequest.getOffset(),pageRequest.getPageSize())
                .stream()
                .map(m->
                        ProductResponseDto.builder()
                                .name(m.getName())
                                .price(String.valueOf(m.getPrice()))
                                .category(m.getCategory())
                                .build())
                .collect(Collectors.toList());
    }


}

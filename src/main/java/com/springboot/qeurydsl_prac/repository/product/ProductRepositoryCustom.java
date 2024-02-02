package com.springboot.qeurydsl_prac.repository.product;

import com.springboot.qeurydsl_prac.entity.Product;
import com.springboot.qeurydsl_prac.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> getProductList(String category);
    List<Product> getProductListWithPage(Long offset, int pageSize);
    List<Product> getProductListWithPageAndSortPriceDesc(Long offset, int pageSize);

}

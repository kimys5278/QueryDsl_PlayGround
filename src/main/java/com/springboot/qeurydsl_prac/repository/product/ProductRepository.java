package com.springboot.qeurydsl_prac.repository.product;

import com.springboot.qeurydsl_prac.entity.Product;
import com.springboot.qeurydsl_prac.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long>,ProductRepositoryCustom {
    List<Product> findByOrderByIdDesc(User user, Pageable pageable);

}

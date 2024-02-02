package com.springboot.qeurydsl_prac.repository.product;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.qeurydsl_prac.entity.Product;
import com.springboot.qeurydsl_prac.entity.QProduct;
import com.springboot.qeurydsl_prac.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom{
    //쿼리 dsl 클래스
    // @Repository 와 JPAQueryFactory 무조건있어야됨.

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public List<Product> getProductList(String category){
        QProduct qProduct = QProduct.product;
        return jpaQueryFactory.select(qProduct)
                .from(qProduct)
                .where(qProduct.category.eq(category))
                .fetch();
    }
    @Override
    public List<Product> getProductListWithPage(Long offset, int pageSize){
        QProduct qProduct = QProduct.product;
        return jpaQueryFactory.select(qProduct)
                .from(qProduct)
                .offset(offset)
                .limit(pageSize)
                .fetch();
    }
    @Override
    public List<Product> getProductListWithPageAndSortPriceDesc(Long offset, int pageSize){
        QProduct qProduct = QProduct.product;
        OrderSpecifier<?> orderSpecifier = new OrderSpecifier<>(Order.DESC,qProduct.price);

        return jpaQueryFactory.selectFrom(qProduct)
                .offset(offset)
                .limit(pageSize)
                .orderBy(orderSpecifier)
                .fetch();
    }

}

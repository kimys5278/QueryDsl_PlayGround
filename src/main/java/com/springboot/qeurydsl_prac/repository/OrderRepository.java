package com.springboot.qeurydsl_prac.repository;

import com.springboot.qeurydsl_prac.entity.Order;
import com.springboot.qeurydsl_prac.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}

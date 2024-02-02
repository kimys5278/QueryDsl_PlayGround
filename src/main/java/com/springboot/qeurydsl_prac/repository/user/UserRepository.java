package com.springboot.qeurydsl_prac.repository.user;

import com.springboot.qeurydsl_prac.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>,UserRepositoryCustom{
}

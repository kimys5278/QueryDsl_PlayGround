package com.springboot.qeurydsl_prac.repository.user;

import com.springboot.qeurydsl_prac.dto.user.UserRequestDto;
import com.springboot.qeurydsl_prac.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> getUserList(String name);
    List<User> getUserListWithPage(Long offset, int size);
}

package com.springboot.qeurydsl_prac.service;

import com.springboot.qeurydsl_prac.dto.user.UserModifyRequestDto;
import com.springboot.qeurydsl_prac.dto.user.UserModifyResponseDto;
import com.springboot.qeurydsl_prac.dto.user.UserRequestDto;
import com.springboot.qeurydsl_prac.dto.user.UserResponseDto;
import com.springboot.qeurydsl_prac.entity.User;

import java.util.List;

public interface UserService {

    UserResponseDto createUser1(User user);

    UserResponseDto createUser2(UserRequestDto userRequestDto);

    UserModifyResponseDto modifyUser(Long id, UserModifyRequestDto modifyRequestDto);

    List<UserResponseDto> getUserList(String name)throws Exception;
    List<UserResponseDto> getUserListWithPage(int page , int size);


}

package com.springboot.qeurydsl_prac.controller;


import com.springboot.qeurydsl_prac.dto.user.UserModifyRequestDto;
import com.springboot.qeurydsl_prac.dto.user.UserModifyResponseDto;
import com.springboot.qeurydsl_prac.dto.user.UserRequestDto;
import com.springboot.qeurydsl_prac.dto.user.UserResponseDto;
import com.springboot.qeurydsl_prac.entity.User;
import com.springboot.qeurydsl_prac.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/v1/get/member")
    public List<UserResponseDto> getUser(@RequestParam String name)throws Exception{
        return userService.getUserList(name);
    }
    @GetMapping("/v1/get/page/member")
    public List<UserResponseDto> getUserPage(@RequestParam("page") int page,
                                             @RequestParam("size") int size){
        return userService.getUserListWithPage(page,size);
    }


    @PostMapping("/v1/member")
    public UserResponseDto createUser1 (@RequestBody  User user){
        return userService.createUser1(user);
        /*
        * user 생성 API Version.1
        * Request에 담긴 User를 받아, 해당 내용을 디비에 저장
        * 문제점 1 -> 클라이언트에게 엔티티 스펙을 그대로 노출해야한다. (보안 문제)
        * 문제점 2 -> User엔티티의 스펙이 변경되는 경우 해당하는 API 모두를 변경해야한다.
        *   즉 , 유저 정보에 성별이 추가된 경우 BE만 수정하는 것이 아닌 ,
        *   이 API를 호출하는 클라이언트들도 다 수정해야함.
        *
        * 문제점 3 -> 본 API는 사용자 id를입력받기 때문에, 새로운 유저만 생성되어야 하는데, 기존 유저에 대해 UPDATE도 발생.
        * 문제점 4 -> 그 외에도 많음... 절대 엔티티 자체를 API에 노출X
        *
        *
        * */

    }

    @PostMapping("/v2/member")
    public UserResponseDto createUser2 (@RequestBody UserRequestDto userRequestDto){
        /*
        * user 생성 API Version.2
        *
        *z */
        return userService.createUser2(userRequestDto);
    }
    @PostMapping("/member/{id}")
    public UserModifyResponseDto modifyUser (@PathVariable Long id, @RequestBody UserModifyRequestDto userModifyRequestDto){
        /*
         * user 생성 API Version.2
         *
         * */
        return userService.modifyUser(id,userModifyRequestDto);
    }


}

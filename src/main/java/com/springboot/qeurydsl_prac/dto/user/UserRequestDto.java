package com.springboot.qeurydsl_prac.dto.user;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
public class UserRequestDto {
    private String name;
    private String address;
    private String email;
}

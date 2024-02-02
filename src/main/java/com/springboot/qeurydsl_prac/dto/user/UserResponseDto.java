package com.springboot.qeurydsl_prac.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private Long id;
    private String email;
    private String name;

    @Builder
    public UserResponseDto(Long id, String email,String name){
        this.id = id;
        this.email = email;
        this.name = name;
    }

}

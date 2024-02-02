package com.springboot.qeurydsl_prac.dto.user;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserModifyResponseDto {
    private Long id;
    private String address;

    @Builder
    public UserModifyResponseDto(Long id , String address){
        this.id = id;
        this.address = address;
    }
}

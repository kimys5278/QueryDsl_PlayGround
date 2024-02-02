package com.springboot.qeurydsl_prac.service.Impl;

import com.springboot.qeurydsl_prac.dto.user.UserModifyRequestDto;
import com.springboot.qeurydsl_prac.dto.user.UserModifyResponseDto;
import com.springboot.qeurydsl_prac.dto.user.UserRequestDto;
import com.springboot.qeurydsl_prac.dto.user.UserResponseDto;
import com.springboot.qeurydsl_prac.entity.QUser;
import com.springboot.qeurydsl_prac.entity.User;
import com.springboot.qeurydsl_prac.repository.user.UserRepository;
import com.springboot.qeurydsl_prac.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto createUser1(User user){
        User user1 = new User();
        user1.setId(user.getId());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setAddress(user.getAddress());

        userRepository.save(user1);

        return UserResponseDto.builder().
                id(user1.getId()).
                email(user1.getEmail()).
                build();
    }

    @Override
    public UserResponseDto createUser2(UserRequestDto userRequestDto){
        User user2 = new User();
        user2.setName(userRequestDto.getName());
        user2.setEmail(userRequestDto.getEmail());
        user2.setAddress(userRequestDto.getAddress());

        userRepository.save(user2);

        return UserResponseDto.builder().
                id(user2.getId()).
                email(user2.getEmail()).
                build();
    }

    @Override
    public UserModifyResponseDto modifyUser(Long id,UserModifyRequestDto modifyRequestDto){
        User user = userRepository.findById(id).orElseThrow();
        user.setAddress(modifyRequestDto.getAddress());
        userRepository.save(user);

        return UserModifyResponseDto.builder().
                id(user.getId()).
                address(user.getAddress())
                .build();

    }

    @Override
    public List<UserResponseDto> getUserList(String name)throws Exception {
        List<UserResponseDto> userResponseDtos;
        if(name.equals(QUser.user.name)){
            new Exception("해당하는 회원이 없습니다.");
        }
        userResponseDtos = userRepository.getUserList(name).stream()
                .map(m ->UserResponseDto.builder()
                        .id(m.getId())
                        .name(m.getName())
                        .email(m.getEmail())
                        .build())
                .collect(Collectors.toList());

        return userResponseDtos;
    }

    @Override
    public List<UserResponseDto> getUserListWithPage(int page,int size) {
        PageRequest pageRequest = PageRequest.of(page+1, size);

        return userRepository.getUserListWithPage(pageRequest.getOffset(),pageRequest.getPageSize())
                .stream()
                .map(m -> UserResponseDto.builder()
                        .id(m.getId())
                        .name(m.getName())
                        .email(m.getEmail())
                        .build())
                .collect(Collectors.toList());
    }
}

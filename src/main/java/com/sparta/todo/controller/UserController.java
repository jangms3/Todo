package com.sparta.todo.controller;

import com.sparta.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    // 모든 유저 조회
    // 특정 유저 조회
    // 유저 생성 -> 인증 인가 로 넘어갈까? 그게 맞겠지?
    // 유저 삭제

}

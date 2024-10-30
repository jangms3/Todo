package com.sparta.todo.controller;

import com.sparta.todo.dto.UserRequestDto;
import com.sparta.todo.dto.UserResponseDto;
import com.sparta.todo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }
    // 모든 유저 조회
    @GetMapping
    public List<UserResponseDto> getAllUsers() {

        return userService.getAllUser();
    }
    // 특정 유저 조회
    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    // 유저 생성
    @PostMapping
    public UserResponseDto createUser(@RequestBody @Valid UserRequestDto userRequestDto) {
        // 유저가 프론트에서 입력을 한다.
        //1. 처음 들어오는 데이터 requestDto
        //2. 이 api가 실행되기 전부터 user의 입력이 타당한지 검증 가능.
        return userService.createUser(userRequestDto);
    }
    // 유저 수정
    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        return userService.updateUserid(id, userRequestDto);
    }
    // 유저 삭제
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}

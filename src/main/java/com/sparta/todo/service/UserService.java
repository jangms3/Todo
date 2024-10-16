package com.sparta.todo.service;

import com.sparta.todo.dto.UserRequestDto;
import com.sparta.todo.dto.UserResponseDto;
import com.sparta.todo.entity.User;
import com.sparta.todo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 모든 유저 조회
    public List<UserResponseDto> getAllUser() {
        return userRepository.findAll().stream()
                .map(user -> UserResponseDto.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .email(user.getEmail())
                        .build())  // 빌더를 사용하여 UserResponseDto 생성
                .collect(Collectors.toList());
    }

    // 특정 유저 조회
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 유저가 없습니다"));
        return UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

    // 유저 생성
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = User.builder()
                .username(userRequestDto.getUsername())
                .email(userRequestDto.getEmail())
                .build();

        User savedUser = userRepository.save(user);
        return UserResponseDto.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .build();
    }

    // 유저 수정
    public UserResponseDto updateUserid(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(userRequestDto.getUsername());
        user.setEmail(userRequestDto.getEmail());

        User updatedUser = userRepository.save(user);

        return UserResponseDto.builder()
                .id(updatedUser.getId())
                .username(updatedUser.getUsername())
                .email(updatedUser.getEmail())
                .build();
    }

    // 유저 삭제
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }
}

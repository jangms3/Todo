package com.sparta.todo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserResponseDto {
    private Long id;
    private String username;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

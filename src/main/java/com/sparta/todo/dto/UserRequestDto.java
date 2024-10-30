package com.sparta.todo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class UserRequestDto {
    @NotNull
    private String username;
    @Email(message = "이메일 형식을 확인해 주세요.")
    private String email;
}

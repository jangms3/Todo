package com.sparta.todo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoRequestDto {
    @Size(min = 2, max = 20)
    private String title;
    @NotEmpty
    private String content;
    @NotNull
    private Long userId;
}

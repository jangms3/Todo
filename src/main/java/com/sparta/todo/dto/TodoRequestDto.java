package com.sparta.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoRequestDto {
    private String title;
    private String content;
    private Long userId;


}

package com.sparta.todo.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReplyRequestDto {
    private String content;
    private Long userId;

}

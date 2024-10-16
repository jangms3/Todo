package com.sparta.todo.dto;

public class ReplyResponseDto {
    private Long id;
    private String content;
    private String username;

    public ReplyResponseDto(Long id, String content,String username) {
        this.id = id;
        this.content = content;
        this.username = username;
    }
}

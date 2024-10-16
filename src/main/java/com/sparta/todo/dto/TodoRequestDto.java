package com.sparta.todo.dto;

public class TodoRequestDto {
    private String title;
    private String content;

    public TodoRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}

package com.sparta.todo.dto;

public class TodoResponseDto {
    private Long id;
    private String title;
    private String content;
    private String username; // 작성자 이름
    private Long replyCount; // 댓글 개수

    public TodoResponseDto(Long id, String title, String content, String username, Long replyCount){
        this.id = id;
        this.title = title;
        this.content = content;
        this.username = username;
        this.replyCount = replyCount;
    }
}

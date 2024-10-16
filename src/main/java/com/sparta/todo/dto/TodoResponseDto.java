package com.sparta.todo.dto;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class TodoResponseDto {
    private Long id;
    private String title;
    private String content;
    private String username; // 작성자 이름
    private Long replyCount; // 댓글 개수
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TodoResponseDto(Long id, String title, String content, String username, long size, LocalDateTime createdAt, LocalDateTime updatedAt) {
    }
}

package com.sparta.todo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class UserTodoRequestDto {
    private Long memberId;
    private Long todoId;
    private Long userId;

}

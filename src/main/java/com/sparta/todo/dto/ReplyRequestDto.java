package com.sparta.todo.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReplyRequestDto {
    @Min(1)
    private String content;
    @NotNull
    private Long userId;

}

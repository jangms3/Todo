package com.sparta.todo.controller;

import com.sparta.todo.dto.ReplyRequestDto;
import com.sparta.todo.dto.ReplyResponseDto;
import com.sparta.todo.service.ReplyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo/{todoId}/reply") //api 주소 확인하고 더 줄일수 있으면 여기다 넣기
public class ReplyController {
    private final ReplyService replyService;

    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }
    // 특정 할 일에 달린 모든 댓글 조회
    @GetMapping
    public List<ReplyResponseDto> getAllReplyByTodoId(@PathVariable Long todoId) {
        return replyService.getReplyByTodoId(todoId);
    }
    // 댓글 단건 조회
    @GetMapping("/{replyId}")
    public ReplyResponseDto getReplyById(@PathVariable Long todoId, @PathVariable Long replyId) {
        return replyService.getReplyById(todoId, replyId);
    }
    // 댓글 생성
    @PostMapping
    public ReplyResponseDto createReply(@PathVariable Long todoId, @RequestBody ReplyRequestDto replyRequestDto) {
        return replyService.createReply(todoId, replyRequestDto);
    }
    // 댓글 수정
    @PutMapping("/{replyId}")
    public ReplyResponseDto updateReply(@PathVariable Long todoId, @PathVariable Long replyId, @RequestBody ReplyRequestDto replyRequestDto) {
        return replyService.updateReply(todoId, replyId, replyRequestDto);
    }
    // 댓글 삭제
    @DeleteMapping("/{replyId}")
    public void deleteReply(@PathVariable Long todoId, @PathVariable Long replyId) {
        replyService.deleteReply(todoId, replyId);
    }

}
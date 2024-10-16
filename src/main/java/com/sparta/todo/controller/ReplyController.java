package com.sparta.todo.controller;

import com.sparta.todo.service.ReplyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo") //api 주소 확인하고 더 줄일수 있으면 여기다 넣기
public class ReplyController {
    private final ReplyService replyService;

    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }
    // 특정 할 일에 달린 모든 댓글 조회
    // 댓글 생성.
}

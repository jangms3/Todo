package com.sparta.todo.service;

import com.sparta.todo.controller.ReplyController;
import com.sparta.todo.repository.ReplyRepository;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
    private final ReplyRepository replyRepository;

    public ReplyService(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }
}

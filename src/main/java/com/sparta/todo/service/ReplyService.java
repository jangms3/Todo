package com.sparta.todo.service;

import com.sparta.todo.dto.ReplyRequestDto;
import com.sparta.todo.dto.ReplyResponseDto;
import com.sparta.todo.entity.Reply;
import com.sparta.todo.entity.Todo;
import com.sparta.todo.entity.User;
import com.sparta.todo.repository.ReplyRepository;
import com.sparta.todo.repository.TodoRepository;
import com.sparta.todo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public ReplyService(ReplyRepository replyRepository, TodoRepository todoRepository, UserRepository userRepository){
        this.replyRepository = replyRepository;
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }
    // 특정 일정에 달린 댓글 목록 조회 관련 서비스
    public List<ReplyResponseDto> getRepliesByTodoId(Long todoId) {
        return replyRepository.findByTodoId(todoId).stream()
                .map(reply -> ReplyResponseDto.builder()
                        .id(reply.getId())
                        .content(reply.getContent())
                        .username(reply.getUser().getUsername())
                        .createdAt(reply.getCreatedAt())
                        .updatedAt(reply.getUpdatedAt())
                        .build())
                .collect(Collectors.toList());
    }
    // 댓글 단건 조회
    public ReplyResponseDto getReplyById(Long todoId, Long replyId) {
        Reply reply = replyRepository.findById(replyId)
                .orElseThrow(() -> new RuntimeException("Reply not found"));

        if (!reply.getTodo().getId().equals(todoId)) {
            throw new RuntimeException("Reply does not belong to this todo");
        }

        return ReplyResponseDto.builder()
                .id(reply.getId())
                .content(reply.getContent())
                .username(reply.getUser().getUsername())
                .createdAt(reply.getCreatedAt())
                .updatedAt(reply.getUpdatedAt())
                .build();
    }
    // 댓글 생성
    public ReplyResponseDto createReply(Long todoId, ReplyRequestDto requestDto) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        User user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Reply reply = new Reply();
        reply.setContent(requestDto.getContent());
        reply.setTodo(todo);
        reply.setUser(user);

        Reply savedReply = replyRepository.save(reply);

        return ReplyResponseDto.builder()
                .id(savedReply.getId())
                .content(savedReply.getContent())
                .username(user.getUsername())
                .createdAt(savedReply.getCreatedAt())
                .updatedAt(savedReply.getUpdatedAt())
                .build();
    }
    // 댓글 수정
    public ReplyResponseDto updateReply(Long todoId, Long replyId, ReplyRequestDto requestDto) {
        Reply reply = replyRepository.findById(replyId)
                .orElseThrow(() -> new RuntimeException("Reply not found"));

        if (!reply.getTodo().getId().equals(todoId)) {
            throw new RuntimeException("Reply does not belong to this todo");
        }

        reply.setContent(requestDto.getContent());

        Reply updatedReply = replyRepository.save(reply);

        return ReplyResponseDto.builder()
                .id(updatedReply.getId())
                .content(updatedReply.getContent())
                .username(updatedReply.getUser().getUsername())
                .createdAt(updatedReply.getCreatedAt())
                .updatedAt(updatedReply.getUpdatedAt())
                .build();
    }
    // 댓글 삭제
    public void deleteReply(Long todoId, Long replyId) {
        Reply reply = replyRepository.findById(replyId)
                .orElseThrow(() -> new RuntimeException("Reply not found"));

        if (!reply.getTodo().getId().equals(todoId)) {
            throw new RuntimeException("Reply does not belong to this todo");
        }

        replyRepository.delete(reply);
    }
}
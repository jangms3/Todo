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
    public List<ReplyResponseDto> getReplyByTodoId(Long todoId) {
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
                .orElseThrow(() -> new RuntimeException("댓글이 존재하지 않습니다."));

        if (!reply.getTodo().getId().equals(todoId)) {
            throw new RuntimeException("댓글은 일정에 속하지 않습니다");
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
                .orElseThrow(() -> new RuntimeException("일정을 찾을 수 없습니다."));

        User user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

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
                .orElseThrow(() -> new RuntimeException("일정이 없습니다."));

        if (!reply.getTodo().getId().equals(todoId)) {
            throw new RuntimeException("댓글이 일정에 속하지 않습니다.");
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
    public void deleteReply(Long todoId, Long replyId, Long userId) {
        // 1. 댓글이 존재하는지 확인해보기
        Reply reply = replyRepository.findById(replyId)
                .orElseThrow(() -> new RuntimeException("해당 댓글이 없습니다."));
        // 2. 댓글이 해당 일정에 속하는지 확인해보기
        if (!reply.getTodo().getId().equals(todoId)) {
            throw new RuntimeException("댓글이 해당 일정에 속해 있지 않습니다.");
        }
        // 3. 댓글이 해당 작성자와 같은지 확인해보기
        if (!reply.getUser().getId().equals(userId)) {
            throw new RuntimeException ("해당 댓글을 삭제할 권한이 없습니다.");
        }
        // 4. 유효성 검증이 완료되면 댓글 삭제
        replyRepository.delete(reply);
    }
}
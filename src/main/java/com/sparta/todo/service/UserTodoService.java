package com.sparta.todo.service;

import com.sparta.todo.entity.Todo;
import com.sparta.todo.entity.User;
import com.sparta.todo.repository.TodoRepository;
import com.sparta.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserTodoService {
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    public void addUserToTodo(Long memberId, Long todoId, Long userId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 없습니다."));

        // 일정 작성자(memberId)가 일치하는지 확인
        if (!todo.getUser().getId().equals(memberId)) {
            throw new IllegalArgumentException("일정 작성자가 아닙니다.");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));

    }
}

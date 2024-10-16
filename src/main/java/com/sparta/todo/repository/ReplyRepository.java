package com.sparta.todo.repository;

import com.sparta.todo.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByTodoId(Long todoId);
}

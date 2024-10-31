package com.sparta.todo.repository;

import com.sparta.todo.entity.Todo;
import com.sparta.todo.entity.User;
import com.sparta.todo.entity.UserTodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTodoRepository extends JpaRepository<UserTodo, Long> {
    boolean existsByUserAndTodo(User user, Todo todo);
}

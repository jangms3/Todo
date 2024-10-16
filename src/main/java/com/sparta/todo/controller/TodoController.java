package com.sparta.todo.controller;

import com.sparta.todo.dto.TodoReponseDto;
import com.sparta.todo.dto.TodoRequestDto;
import com.sparta.todo.entity.Todo;
import com.sparta.todo.repository.TodoRepository;
import com.sparta.todo.service.TodoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController (TodoService todoService) {
        this.todoService =todoService;
    }

    }
}

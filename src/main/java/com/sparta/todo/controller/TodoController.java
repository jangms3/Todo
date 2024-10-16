package com.sparta.todo.controller;


import com.sparta.todo.dto.TodoResponseDto;
import com.sparta.todo.service.TodoService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController (TodoService todoService) {
        this.todoService = todoService;
    }
    //할일 목록 조회 (페이징)
    @GetMapping
    public Page<TodoResponseDto> getAllTodo(
            @RequestParam(value = "page",defaultValue="0") int page,
            @RequestParam(value ="size",defaultValue = "10") int size) {
        return todoService.getAllTodo() (page, size);
    }
    // 할일 단건 조회
    // 할일 생성
    // 할일 삭제
}


package com.sparta.todo.controller;


import com.sparta.todo.dto.TodoRequestDto;
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
    //일정 목록 조회 (페이징)
    @GetMapping("/page")
    public Page<TodoResponseDto> getAllTodos(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return todoService.getAllTodo(page, size);
    }
    // 일정 단건 조회
    @GetMapping("/{id}")
    public TodoResponseDto getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }
    // 일정 생성
    @PostMapping
    public TodoResponseDto createTodo(@RequestBody TodoRequestDto todoRequestDto) {
        return todoService.createTodo(todoRequestDto);
    }
    // 일정 수정
    @PutMapping("/{id}")
    public TodoResponseDto updateTodo(
            @PathVariable Long id,
            @RequestBody TodoRequestDto todoRequestDto) {
        return todoService.updateTodo(todoRequestDto);
    }
    // 일정 삭제
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}


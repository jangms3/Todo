package com.sparta.todo.service;

import com.sparta.todo.entity.Todo;
import com.sparta.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    // 생성자 주입 방식 -> Autowired 는 권장 x 한다고 했었음.
    private final TodoRepository todoRepository; //? 오탄가?

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository =todoRepository;
    }
    public List<Todo> getAllTodo(){
        return todoRepository.findAll();
    }

}

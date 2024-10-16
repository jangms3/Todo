package com.sparta.todo.service;
import com.sparta.todo.dto.TodoResponseDto;
import com.sparta.todo.entity.Todo;
import com.sparta.todo.repository.TodoRepository;
import com.sparta.todo.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    // 생성자 주입 방식 -> Autowired 는 권장 x 한다고 했었음.
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public TodoService(TodoRepository todoRepository,UserRepository userRepository) {
        this.todoRepository =todoRepository;
        this.userRepository =userRepository;
    }
    public List<Todo> getAllTodo(){
        PageRequest pageRequest = PageRequest.of(0, 10);
        return todoRepository.findAll(pageRequest)
                .map(todo -> new TodoResponseDto(
                        todo.getId(),
                        todo.getTitle(),
                        todo.getContent(),
                        todo.getUser().getUsername(),
                        (long) todo.getReply().size()
        ));
    }

    //DTO -> Entity 로 변환 후 DB 저장


}

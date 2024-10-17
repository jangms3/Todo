package com.sparta.todo.service;

import com.sparta.todo.dto.TodoRequestDto;
import com.sparta.todo.dto.TodoResponseDto;
import com.sparta.todo.entity.Todo;
import com.sparta.todo.entity.User;
import com.sparta.todo.repository.TodoRepository;
import com.sparta.todo.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    // 생성자 주입 방식 -> Autowired 는 권장 x 한다고 했었음.
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public TodoService(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    // 모든 일정 조회 관련 서비스
    public Page<TodoResponseDto> getAllTodo(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return todoRepository.findAll(pageRequest)
                .map(todo -> new TodoResponseDto(
                        todo.getId(),
                        todo.getTitle(),
                        todo.getContent(),
                        todo.getUser().getUsername(),
                        (long) todo.getReply().size(),
                        todo.getCreatedAt(),
                        todo.getUpdatedAt()
                ));
    }

    // 특정 일정 조회 관련 서비스
    public TodoResponseDto getTodoById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 일정이 없습니다."));

        return new TodoResponseDto(
                todo.getId(),
                todo.getTitle(),
                todo.getContent(),
                todo.getUser().getUsername(),
                (long) todo.getReply().size(),
                todo.getCreatedAt(),
                todo.getUpdatedAt()
        );
    }

    // 2. 일정 생성 관련 서비스
    public TodoResponseDto createTodo(TodoRequestDto todoRequestDto) {
        // 1. 요청에서 유저 ID를 가져와 유저를 조회
        User user = userRepository.findById(todoRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("유저가 없습니다."));

        // 2. 새로운 Todo 엔티티 생성
        Todo todo = new Todo();
        todo.setTitle(todoRequestDto.getTitle());
        todo.setContent(todoRequestDto.getContent());
        todo.setUser(user); // 할 일 작성자를 유저로 설정

        // 3. DB에 저장
        Todo savedTodo = todoRepository.save(todo);

        // 4. 저장된 할 일을 TodoResponseDTO로 변환하여 반환
        return new TodoResponseDto(
                savedTodo.getId(),
                savedTodo.getTitle(),
                savedTodo.getContent(),
                user.getUsername(),
                0L,  // 새로 생성된 할 일이므로 댓글 수는 0
                savedTodo.getCreatedAt(),
                savedTodo.getUpdatedAt()
        );
    }

    // 일정 수정 관련 서비스
    public TodoResponseDto updateTodo(TodoRequestDto requestDTO) {
        User user = userRepository
                .findById(requestDTO.getUserId()).orElseThrow(() -> new RuntimeException("유저가 없습니다"));

        Todo todo = new Todo();
        todo.setTitle(requestDTO.getTitle());
        todo.setContent(requestDTO.getContent());
        todo.setUser(user);

        Todo savedTodo = todoRepository.save(todo);

        return new TodoResponseDto(
                savedTodo.getId(),
                savedTodo.getTitle(),
                savedTodo.getContent(),
                user.getUsername(),
                0L,
                savedTodo.getCreatedAt(),
                savedTodo.getUpdatedAt()
        );
    }

    // 일정 삭제 관련 서비스
    public void deleteTodo(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new RuntimeException("해당 일정이 존재하지 않습니다");
        }
        todoRepository.deleteById(id);
    }
}

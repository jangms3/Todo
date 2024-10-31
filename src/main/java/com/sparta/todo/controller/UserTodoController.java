import com.sparta.todo.dto.UserTodoRequestDto;
import com.sparta.todo.service.UserTodoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usertodo")
public class UserTodoController {

    private final UserTodoService userTodoService;

    public UserTodoController(UserTodoService userTodoService) {
        this.userTodoService = userTodoService;
    }

    // 특정 일정의 작성자가 단일 유저를 추가로 배치
    @PostMapping("/add")
    public void addUserToTodo(@RequestBody UserTodoRequestDto requestDto) {
        userTodoService.addUserToTodo(requestDto.getMemberId(), requestDto.getTodoId(), requestDto.getUserId());
    }
}

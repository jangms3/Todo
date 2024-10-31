package com.sparta.todo.entity;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class UserTodo { //중간 테이블의 느낌을 구현하고 싶었다 이걸 원한게 아닐까? 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public UserTodo(User user, Todo todo) {
        this.user = user;
        this.todo = todo;
    }
    
}

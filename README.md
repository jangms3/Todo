todo -> 일정 관리 앱 devlop
        일정, 댓글, 유저 CRUD 구현 + 페이징 조회

        지연로딩 과 관계형 데이터베이스 구축 

        JWT를 활용한 로그인/회원가입 구현하기 x
        


![일정 api](https://github.com/user-attachments/assets/e61dc863-60b6-413a-b347-14fbd4ccaa15)
![댓글 api ](https://github.com/user-attachments/assets/cdc9f174-0d03-4420-aba6-90bb296c0df5)
![유저 api](https://github.com/user-attachments/assets/09b1ce26-faca-44ef-bf58-6d2743fc0eb9)
![일정 todo](https://github.com/user-attachments/assets/cbc7c8a5-48db-41e1-9155-c27d3f6de52a)

파일 트리
    📦sparta
 ┗ 📂todo
 ┃ ┣ 📂auth
 ┃ ┃ ┗ 📜AuthController.java
 ┃ ┣ 📂config
 ┃ ┃ ┣ 📜PasswordConfig.java
 ┃ ┃ ┗ 📜WebSecurityConfig.java
 ┃ ┣ 📂controller
 ┃ ┃ ┣ 📜ReplyController.java
 ┃ ┃ ┣ 📜TodoController.java
 ┃ ┃ ┗ 📜UserController.java
 ┃ ┣ 📂dto
 ┃ ┃ ┣ 📜ReplyRequestDto.java
 ┃ ┃ ┣ 📜ReplyResponseDto.java
 ┃ ┃ ┣ 📜TodoRequestDto.java
 ┃ ┃ ┣ 📜TodoResponseDto.java
 ┃ ┃ ┣ 📜UserRequestDto.java
 ┃ ┃ ┗ 📜UserResponseDto.java
 ┃ ┣ 📂entity
 ┃ ┃ ┣ 📜Reply.java
 ┃ ┃ ┣ 📜Todo.java
 ┃ ┃ ┗ 📜User.java
 ┃ ┣ 📂filter
 ┃ ┃ ┣ 📜AuthFilter.java
 ┃ ┃ ┗ 📜LoggingFilter.java
 ┃ ┣ 📂jwt
 ┃ ┣ 📂repository
 ┃ ┃ ┣ 📜ReplyRepository.java
 ┃ ┃ ┣ 📜TodoRepository.java
 ┃ ┃ ┗ 📜UserRepository.java
 ┃ ┣ 📂security
 ┃ ┣ 📂service
 ┃ ┃ ┣ 📜ReplyService.java
 ┃ ┃ ┣ 📜TodoService.java
 ┃ ┃ ┗ 📜UserService.java
 ┃ ┗ 📜ToDoApplication.java

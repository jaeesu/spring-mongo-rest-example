package com.example.mongodemo.user.presentation;

import com.example.mongodemo.user.presentation.out.UserListResponse;
import com.example.mongodemo.user.presentation.in.UserCreationRequest;
import com.example.mongodemo.user.application.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        UserListResponse allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") String id) {
        UserListResponse.UserDto user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody @Valid UserCreationRequest request) {
        userService.createUser(request);
        return ResponseEntity.ok("사용자 생성 성공");
    }

    @PutMapping("/users")
    public ResponseEntity<?> updateUser(@RequestBody @Valid UserCreationRequest request) {
        userService.updateUser(request);
        return ResponseEntity.ok("사용자 수정 성공");
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("사용자 삭제 성공");
    }

}

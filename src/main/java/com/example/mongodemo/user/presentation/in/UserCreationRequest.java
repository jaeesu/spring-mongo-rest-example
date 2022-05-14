package com.example.mongodemo.user.presentation.in;

import com.example.mongodemo.user.domain.User;
import lombok.Data;

@Data
public class UserCreationRequest {

    private String id;
    private String name;
    private String email;
    private Integer age;
    private String gender;

    public User toEntity() {
        return User.builder()
                .id(this.id)
                .name(this.name)
                .email(this.email)
                .age(this.age)
                .gender(this.gender)
                .build();
    }
}

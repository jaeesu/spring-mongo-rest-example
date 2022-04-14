package com.example.mongodemo.service;

import com.example.mongodemo.model.user.User;
import com.example.mongodemo.payload.reponse.UserListResponse;
import com.example.mongodemo.payload.request.UserCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final MongoTemplate mongoTemplate;

    public UserListResponse getAllUser() {
        List<User> userList = mongoTemplate.findAll(User.class);
        return UserListResponse.fromEntity(userList);
    }

    public UserListResponse.UserDto getUser(String id) {
        User user = mongoTemplate.findOne(
                Query.query(Criteria.where("id").is(id)),
                User.class
        );

        return UserListResponse.UserDto.fromEntity(user);
    }

    public void createUser(UserCreationRequest request) {
        User user = request.toEntity();
        mongoTemplate.insert(user);
    }

    public void updateUser(UserCreationRequest request) {
        mongoTemplate.updateFirst(
                Query.query(Criteria.where("id").is(request.getId())),
                new Update() {{
                   set("name", request.getName());
                           set("email", request.getEmail());
                           set("age", request.getAge());
                           set("gender", request.getGender());
                }},
                User.class
        );
    }

    public void deleteUser(String id) {
        mongoTemplate.findAndRemove(
                Query.query(Criteria.where("id").is(id)),
                User.class
        );
    }


}

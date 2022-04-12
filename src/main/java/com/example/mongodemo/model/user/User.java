package com.example.mongodemo.model.user;

import com.example.mongodemo.model.post.Post;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "user")
public class User {

    @Id
    @Field(name = "_id")
    private String id;
    private String name;
    private String email;
    private Integer age;
    private String gender;

    @Field(name = "user_post")
    private List<Post> postList;

}

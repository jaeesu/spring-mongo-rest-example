package com.example.mongodemo.model.post;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "board")
public class Post {

    @Id
    @Field(name = "_id")
    private Long id;
    private String userId;
    private String title;
    private String content;
    private LocalDateTime timestamp;
}

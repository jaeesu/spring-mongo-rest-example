package com.example.mongodemo.model.image;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "user_image")
public class UserImage {

    @Id
    @Field(name = "_id")
    private String id;

    @Field(name = "file_name")
    private String fileName;

    private byte[] image;

}

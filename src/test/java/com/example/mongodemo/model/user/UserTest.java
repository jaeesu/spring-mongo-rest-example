package com.example.mongodemo.model.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@DataMongoTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    @Order(1)
    @DisplayName("일반적인 형태의 사용자 저장 테스트")
    void insertTest() {
        User user = User.builder()
                .id("user12345")
                .name("user1234")
                .email("user@email.com")
                .age(30)
                .gender("female")
                .build();
        mongoTemplate.insert(user);
        Assertions.assertThat(mongoTemplate.findAll(User.class).size()).isEqualTo(1);
    }

    @Test
    @Order(2)
    @DisplayName("이전 테스트와는 다른 형태의 사용자 저장 테스트")
    void insertTest2() {
        User user = User.builder()
                .id("user1234")
                .email("user@email.com")
                .build();
        mongoTemplate.insert(user);
        Assertions.assertThat(mongoTemplate.findAll(User.class).size()).isEqualTo(2);
    }

    @Test
    @Order(3)
    @DisplayName("사용자 조회 테스트")
    void getTest() {
        User user = mongoTemplate.findOne(
                Query.query(Criteria.where("id").is("user12345")),
                User.class
        );

        Assertions.assertThat(user.getId()).isEqualTo("user12345");
        Assertions.assertThat(user.getName()).isEqualTo("user1234");
        Assertions.assertThat(user.getEmail()).isEqualTo("user@email.com");
        Assertions.assertThat(user.getId()).isEqualTo("user12345");
        Assertions.assertThat(user.getAge()).isEqualTo(30);
        Assertions.assertThat(user.getGender()).isEqualTo("female");
    }

    @Test
    @Order(4)
    @DisplayName("사용자 정보 수정 테스트")
    void updateTest() {
        //given
        mongoTemplate.updateFirst(
                Query.query(Criteria.where("id").is("user12345")),
                new Update() {{
                    set("name", "user111");
                }},
                User.class
        );

        //when
        User user = mongoTemplate.findOne(
                Query.query(Criteria.where("id").is("user12345")),
                User.class
        );

        //then
        Assertions.assertThat(user.getName()).isEqualTo("user111");
    }


    @Test
    @Order(5)
    @DisplayName("사용자 삭제 테스트")
    void deleteTest() {
        mongoTemplate.remove(
                Query.query(Criteria.where("id").in("user12345", "user1234")),
                User.class
        );

        Assertions.assertThat(mongoTemplate.findAll(User.class).size()).isEqualTo(0);
    }

}
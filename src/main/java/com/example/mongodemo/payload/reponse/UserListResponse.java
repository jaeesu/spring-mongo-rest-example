package com.example.mongodemo.payload.reponse;

import com.example.mongodemo.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@AllArgsConstructor
public class UserListResponse {

    List<UserDto> data;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class UserDto {
        private String id;
        private String name;
        private String email;
        private Integer age;
        private String gender;

        public static UserDto fromEntity(User user) {
            return UserDto.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .age(user.getAge())
                    .gender(user.getGender())
                    .build();
        }
    }

    public static UserListResponse fromEntity(List<User> userList) {
        List<UserDto> dtoList = userList.stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
        return new UserListResponse(dtoList);
    }


}

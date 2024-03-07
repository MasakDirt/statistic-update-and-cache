package org.techtask.mapper.impl;

import org.techtask.mapper.UserMapper;
import org.techtask.dto.UserCreateRequest;
import org.techtask.dto.UserResponse;
import org.techtask.dto.UserTokenResponse;
import org.techtask.entity.User;

public class UserMapperImpl implements UserMapper {

    @Override
    public UserTokenResponse getUserTokenResponse(String email, String token) {
        return UserTokenResponse.builder()
                .userEmail(email)
                .token(token)
                .build();
    }

    @Override
    public User getEntityFromCreateRequest(UserCreateRequest userCreateRequest) {
        User user = new User();
        user.setEmail(userCreateRequest.getEmail());
        user.setFullName(userCreateRequest.getFullName());
        user.setPassword(userCreateRequest.getPassword());

        return user;
    }

    @Override
    public UserResponse createUserResponseFromEntity(User user) {
        return UserResponse.builder()
                .email(user.getEmail())
                .fullName(user.getFullName())
                .password(user.getPassword())
                .myRole(user.getMyRole().name())
                .build();
    }
}

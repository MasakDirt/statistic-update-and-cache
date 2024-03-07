package org.techtask.mapper;

import org.mapstruct.Mapper;
import org.techtask.dto.UserCreateRequest;
import org.techtask.dto.UserResponse;
import org.techtask.dto.UserTokenResponse;
import org.techtask.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserTokenResponse getUserTokenResponse(String email, String token);

    User getEntityFromCreateRequest(UserCreateRequest userCreateRequest);

    UserResponse createUserResponseFromEntity(User user);

}

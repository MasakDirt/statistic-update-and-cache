package org.techtask.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.techtask.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techtask.dto.LoginRequest;
import org.techtask.dto.UserCreateRequest;
import org.techtask.dto.UserResponse;
import org.techtask.dto.UserTokenResponse;
import org.techtask.util.JwtUtils;
import org.techtask.service.UserService;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<UserTokenResponse> login(
            @Valid @RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        var user = userService.getByEmail(email);
        userService.isPasswordMatches(loginRequest.getPassword(), user.getPassword());
        String token = jwtUtils.generateTokenFromUsername(user.getUsername());
        log.info("=== POST-LOGIN === auth.name - {} == time - {}",
                email, LocalDateTime.now());

        return ResponseEntity.ok(userMapper.getUserTokenResponse(email, token));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> createNewCustomer
            (@RequestBody @Valid UserCreateRequest userCreateRequest) {
        var user = userService.registerUser(userMapper.getEntityFromCreateRequest(userCreateRequest));
        log.info("=== POST-REGISTER === reg.name - {} == time - {}",
                user.getUsername(), LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userMapper.createUserResponseFromEntity(user));
    }
}

package org.techtask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.techtask.repository.UserRepository;
import org.techtask.service.UserService;
import org.techtask.service.impl.UserServiceImpl;

@Configuration
@ComponentScan(basePackages = "org.techtask.service")
public class ContextConfig {

    @Bean
    public UserService userService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return new UserServiceImpl(userRepository, passwordEncoder);
    }

}

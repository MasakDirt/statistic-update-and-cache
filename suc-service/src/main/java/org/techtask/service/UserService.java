package org.techtask.service;

import org.springframework.stereotype.Service;
import org.techtask.entity.User;

@Service
public interface UserService {

    User registerUser(User user);

    User getByEmail(String email);

    User getById(String id);

    void isPasswordMatches(String rawPass, String encodedPass);

}

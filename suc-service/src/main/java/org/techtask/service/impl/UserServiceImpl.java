package org.techtask.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;
import org.techtask.entity.User;
import org.techtask.entity.addition.Role;
import org.techtask.exception.EntityNotFoundException;
import org.techtask.exception.InvalidDataException;
import org.techtask.exception.InvalidUserException;
import org.techtask.repository.UserRepository;
import org.techtask.service.UserService;

@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) {
        userCheckingAndSettingFields(user);
        User created = userRepository.save(user);
        log.info("User '{}' successfully saved to DB.", user.getUsername());
        return created;
    }

    private void userCheckingAndSettingFields(User user) {
        checkUserForNull(user);
        encodeUserPassword(user);
        user.setMyRole(Role.USER);
    }

    private void checkUserForNull(User user) throws InvalidDataException {
        if (user == null) {
            log.error("'registerUser' - null user passed!");
            throw new InvalidUserException("Sorry, something went wrong!");
        }
    }

    private void encodeUserPassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    @Override
    public User getByEmail(java.lang.String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public User getById(java.lang.String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public void isPasswordMatches(java.lang.String rawPass, java.lang.String encodedPass) {
        if (!passwordEncoder.matches(rawPass, encodedPass)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong password");
        }
    }
}

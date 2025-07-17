package com.smartretail.user.service;

import com.smartretail.common.dto.UserDto;
import com.smartretail.user.entity.User;
import com.smartretail.user.event.UserEventProducer;
import com.smartretail.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserEventProducer eventProducer;

    public String register(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        repo.save(toEntity(userDto));
        eventProducer.sendUserCreatedEvent(userDto);
        return jwtService.generateToken(userDto.getUsername());
    }

    public String login(String username, String password) {
        User user = repo.findById(username).orElseThrow();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwtService.generateToken(username);
    }

    private User toEntity(UserDto dto) {
        return User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .role(dto.getRole())
                .build();
    }
}

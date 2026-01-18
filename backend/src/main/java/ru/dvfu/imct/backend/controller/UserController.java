package ru.dvfu.imct.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.dvfu.imct.backend.model.dto.UserRegistrationDTO;
import ru.dvfu.imct.backend.mapper.UserMapper;
import ru.dvfu.imct.backend.service.UserService;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Пользователи", description = "Взаимодействие с пользователями")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "регистрация пользователя")
    @PostMapping("/register")
    public UserRegistrationDTO register(@RequestBody UserRegistrationDTO userRegistrationDto) {
        return UserMapper.toDTO(userService.register(userRegistrationDto));
    }

    @Operation(summary = "логин пользователя")
    @GetMapping("/login")
    public UserRegistrationDTO login(@RequestParam String login, @RequestParam String password) {
        return UserMapper.toDTO(userService.login(login, password));
    }
}

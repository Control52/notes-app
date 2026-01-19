package ru.dvfu.imct.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.dvfu.imct.backend.controller.api.UserControllerApi;
import ru.dvfu.imct.backend.model.dto.UserRegistrationDTO;
import ru.dvfu.imct.backend.model.dto.UserLoginDTO;
import ru.dvfu.imct.backend.mapper.UserMapper;
import ru.dvfu.imct.backend.service.UserService;

@RestController
public class UserController implements UserControllerApi {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserRegistrationDTO register(UserRegistrationDTO userRegistrationDto) {
        return UserMapper.toDTO(userService.register(userRegistrationDto));
    }

    @Override
    public UserRegistrationDTO login(UserLoginDTO loginDto) {
        return UserMapper.toDTO(userService.login(loginDto.getLogin(), loginDto.getPassword()));
    }
}

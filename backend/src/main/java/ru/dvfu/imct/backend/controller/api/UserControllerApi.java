package ru.dvfu.imct.backend.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.dvfu.imct.backend.model.dto.UserRegistrationDTO;
import ru.dvfu.imct.backend.model.dto.UserLoginDTO;

@RequestMapping("/api/users")
@Tag(name = "Пользователи", description = "Взаимодействие с пользователями")
public interface UserControllerApi {

    @Operation(summary = "регистрация пользователя")
    @PostMapping("/register")
    UserRegistrationDTO register(@RequestBody UserRegistrationDTO userRegistrationDto);

    @Operation(summary = "логин пользователя")
    @PostMapping("/login")
    UserRegistrationDTO login(@RequestBody UserLoginDTO loginDto);
}

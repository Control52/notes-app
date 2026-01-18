package ru.dvfu.imct.backend.mapper;

import ru.dvfu.imct.backend.model.dto.UserRegistrationDTO;
import ru.dvfu.imct.backend.model.dto.UserResponseDTO;
import ru.dvfu.imct.backend.model.entity.User;

public class UserMapper {
    public static User toEntity(UserRegistrationDTO dto) {
        if (dto == null)
            return null;
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        return user;
    }

    public static UserRegistrationDTO toDTO(User user) {
        if (user == null)
            return null;
        UserRegistrationDTO dto = new UserRegistrationDTO();
        dto.setUsername(user.getUsername());
        dto.setLogin(user.getLogin());
        dto.setPassword(user.getPassword());
        return dto;
    }

    public static UserResponseDTO toResponseDTO(User user) {
        if (user == null)
            return null;
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setLogin(user.getLogin());
        return dto;
    }
}

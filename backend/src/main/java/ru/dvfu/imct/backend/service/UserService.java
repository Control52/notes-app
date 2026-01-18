package ru.dvfu.imct.backend.service;

import org.springframework.stereotype.Service;
import ru.dvfu.imct.backend.model.dto.UserRegistrationDTO;
import ru.dvfu.imct.backend.model.entity.User;
import ru.dvfu.imct.backend.repository.UserRepository;
import ru.dvfu.imct.backend.exception.NotFoundException;
import ru.dvfu.imct.backend.exception.AlreadyExistsException;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(UserRegistrationDTO dto) {
        if (userRepository.findByLogin(dto.getLogin()).isPresent()) {
            throw new AlreadyExistsException("Логин уже занят");
        }
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        return userRepository.save(user);
    }

    public User login(String login, String password) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        if (!user.getPassword().equals(password)) {
            throw new NotFoundException("Неверный пароль");
        }
        return user;
    }
}

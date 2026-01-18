package ru.dvfu.imct.backend.model.entity;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "users")
public class User {

    @Schema(description = "ID пользователя")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Имя пользователя")
    @Column(name = "username", length = 50)
    private String username;

    @Schema(description = "Логин пользователя")
    @Column(name = "login", length = 50, unique = true, nullable = false)
    private String login;

    @Schema(description = "Пароль пользователя")
    @Column(name = "password", length = 255, nullable = false)
    private String password;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
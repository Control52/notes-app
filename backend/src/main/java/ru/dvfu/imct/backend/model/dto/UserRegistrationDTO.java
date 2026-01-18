
package ru.dvfu.imct.backend.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Данные для регистрации пользователя")
public class UserRegistrationDTO {
    @Schema(description = "Имя пользователя")
    private String username;
    @Schema(description = "Логин пользователя")
    private String login;
    @Schema(description = "Пароль пользователя")
    private String password;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


package ru.dvfu.imct.backend.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Данные для создания тега")
public class TagCreateDTO {
    @Schema(description = "Название тега")
    private String title;
    @Schema(description = "ID пользователя")
    private Long userId;

    public TagCreateDTO() {
    }

    public TagCreateDTO(String title, Long userId) {
        this.title = title;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

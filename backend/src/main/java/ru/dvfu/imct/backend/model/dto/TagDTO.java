
package ru.dvfu.imct.backend.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ответ с тегом")
public class TagDTO {
    @Schema(description = "ID тега")
    private Long id;
    @Schema(description = "Название тега")
    private String title;
    @Schema(description = "ID пользователя")
    private Long userId;

    public TagDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

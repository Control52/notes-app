
package ru.dvfu.imct.backend.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Данные для создания папки")
public class FolderCreateDTO {
    @Schema(description = "Название папки")
    private String title;
    @Schema(description = "ID пользователя")
    private Long userId;

    public FolderCreateDTO() {
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

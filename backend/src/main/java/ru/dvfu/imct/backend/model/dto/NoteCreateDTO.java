
package ru.dvfu.imct.backend.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;

@Schema(description = "Данные для создания заметки")
public class NoteCreateDTO {
    @Schema(description = "Заголовок заметки")
    private String title;
    @Schema(description = "Содержимое заметки")
    private String content;
    @Schema(description = "ID пользователя")
    private Long userId;
    @Schema(description = "ID папки")
    private Long folderId;
    @Schema(description = "ID тегов")
    private Set<Long> tagIds;

    public NoteCreateDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFolderId() {
        return folderId;
    }

    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }

    public Set<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(Set<Long> tagIds) {
        this.tagIds = tagIds;
    }

}

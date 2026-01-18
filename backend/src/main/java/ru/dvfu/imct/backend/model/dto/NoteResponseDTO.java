
package ru.dvfu.imct.backend.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

import java.util.Set;

@Schema(description = "Ответ с заметкой")
public class NoteResponseDTO {
    @Schema(description = "ID заметки")
    private Long id;
    @Schema(description = "Заголовок заметки")
    private String title;
    @Schema(description = "Содержимое заметки")
    private String content;
    @Schema(description = "Дата создания")
    private LocalDateTime createdAt;
    @Schema(description = "ID пользователя")
    private Long userId;
    @Schema(description = "Имя пользователя")
    private String username;
    @Schema(description = "ID папки")
    private Long folderId;
    @Schema(description = "Название папки")
    private String folderTitle;
    @Schema(description = "Список тегов")
    private Set<TagDTO> tags;

    public NoteResponseDTO() {
    }

    public Set<TagDTO> getTags() {
        return tags;
    }

    public void setTags(Set<TagDTO> tags) {
        this.tags = tags;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getFolderId() {
        return folderId;
    }

    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }

    public String getFolderTitle() {
        return folderTitle;
    }

    public void setFolderTitle(String folderTitle) {
        this.folderTitle = folderTitle;
    }
}

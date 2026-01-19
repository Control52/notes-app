package ru.dvfu.imct.backend.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.dvfu.imct.backend.model.dto.TagDTO;
import ru.dvfu.imct.backend.model.dto.TagCreateDTO;

import java.util.List;

@RequestMapping("/api/tags")
@Tag(name = "Теги", description = "Управление тегами для заметок")
public interface TagControllerApi {

    @Operation(summary = "Получить все теги пользователя")
    @GetMapping
    List<TagDTO> getTagsByUser(@RequestParam Long userId);

    @Operation(summary = "Создать тег")
    @PostMapping
    TagDTO createTag(@RequestBody TagCreateDTO tagCreateDTO);

    @Operation(summary = "Удалить тег")
    @DeleteMapping("/{tagId}")
    void deleteTag(@PathVariable Long tagId);
}

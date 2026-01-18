package ru.dvfu.imct.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.dvfu.imct.backend.model.dto.TagDTO;
import ru.dvfu.imct.backend.model.dto.TagCreateDTO;
import ru.dvfu.imct.backend.service.TagService;
import ru.dvfu.imct.backend.mapper.TagMapper;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
@Tag(name = "Теги", description = "Управление тегами для заметок")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @Operation(summary = "Получить все теги пользователя")
    @GetMapping
    public List<TagDTO> getTagsByUser(@RequestParam Long userId) {
        return tagService.getTagsByUser(userId).stream().map(TagMapper::toDTO).toList();
    }

    @Operation(summary = "Создать тег")
    @PostMapping
    public TagDTO createTag(@RequestBody TagCreateDTO tagCreateDTO) {
        return TagMapper.toDTO(tagService.createTag(tagCreateDTO));
    }

    @Operation(summary = "Удалить тег")
    @DeleteMapping("/{tagId}")
    public void deleteTag(@PathVariable Long tagId) {
        tagService.deleteTag(tagId);
    }
}

package ru.dvfu.imct.backend.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.dvfu.imct.backend.model.dto.NoteCreateDTO;
import ru.dvfu.imct.backend.model.dto.NoteResponseDTO;

import java.util.List;

@RequestMapping("/api/notes")
@Tag(name = "Заметки", description = "Управление персональными заметками")
public interface NoteControllerApi {

    @Operation(summary = "Получить все заметки")
    @GetMapping
    List<NoteResponseDTO> getAllNotes();

    @Operation(summary = "Получить список выполненных заметок")
    @GetMapping("/completed")
    List<NoteResponseDTO> getCompletedNotes();

    @Operation(summary = "Поиск заметок по ключевому слову")
    @GetMapping("/search")
    List<NoteResponseDTO> search(@RequestParam String keyword);

    @Operation(summary = "Выдача всех заметок в папке")
    @GetMapping("/folder/{folderId}")
    List<NoteResponseDTO> getNotesByFolder(@PathVariable Long folderId, @RequestParam Long userId);

    @Operation(summary = "Получить заметку по id")
    @GetMapping("/{id}")
    NoteResponseDTO getNoteById(@PathVariable Long id);

    @Operation(summary = "Создание заметки")
    @PostMapping
    NoteResponseDTO createNote(@RequestBody NoteCreateDTO noteCreateDto);

    @Operation(summary = "Обновление существующей заметки")
    @PutMapping("/{id}")
    NoteResponseDTO updateNote(@PathVariable Long id, @RequestBody NoteCreateDTO noteDto);

    @Operation(summary = "Удалить заметку")
    @DeleteMapping("/{id}")
    void deleteNote(@PathVariable Long id);
}

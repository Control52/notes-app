package ru.dvfu.imct.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.dvfu.imct.backend.model.dto.NoteCreateDTO;
import ru.dvfu.imct.backend.model.dto.NoteResponseDTO;
import ru.dvfu.imct.backend.service.NoteService;
import ru.dvfu.imct.backend.mapper.NoteMapper;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@Tag(name = "Заметки", description = "Управление персональными заметками")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @Operation(summary = "Получить все заметки")
    @GetMapping
    public List<NoteResponseDTO> getAllNotes() {
        return noteService.getAllNotes().stream()
                .map(NoteMapper::toResponseDTO)
                .toList();
    }

    @Operation(summary = "Получить список выполненных заметок")
    @GetMapping("/completed")
    public List<NoteResponseDTO> getCompletedNotes() {
        return noteService.getCompletedNotes().stream()
                .map(NoteMapper::toResponseDTO)
                .toList();
    }

    @Operation(summary = "Поиск заметок по ключевому слову")
    @GetMapping("/search")
    public List<NoteResponseDTO> search(@RequestParam String keyword) {
        return noteService.getNoteByKeyword(keyword).stream()
                .map(NoteMapper::toResponseDTO)
                .toList();
    }

    @Operation(summary = "Выдача всех заметок в папке")
    @GetMapping("/folder/{folderId}")
    public List<NoteResponseDTO> getNotesByFolder(
            @PathVariable Long folderId,
            @RequestParam Long userId) {
        return noteService.getNotesByFolderAndUser(folderId, userId).stream()
                .map(NoteMapper::toResponseDTO)
                .toList();
    }

    @Operation(summary = "Получить заметку по id")
    @GetMapping("/{id}")
    public NoteResponseDTO getNoteById(@PathVariable Long id) {
        return NoteMapper.toResponseDTO(noteService.getNoteById(id));
    }

    @Operation(summary = "Создание заметки")
    @PostMapping
    public NoteResponseDTO createNote(@RequestBody NoteCreateDTO noteCreateDto) {
        return NoteMapper.toResponseDTO(noteService.createNote(noteCreateDto));
    }

    @Operation(summary = "Обновление существующей заметки")
    @PutMapping("/{id}")
    public NoteResponseDTO updateNote(@PathVariable Long id, @RequestBody NoteCreateDTO noteDto) {
        return NoteMapper.toResponseDTO(noteService.updateNote(id, noteDto));
    }

    @Operation(summary = "Удалить заметку")
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }

}

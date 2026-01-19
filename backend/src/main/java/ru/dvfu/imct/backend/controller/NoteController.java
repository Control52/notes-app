package ru.dvfu.imct.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.dvfu.imct.backend.controller.api.NoteControllerApi;
import ru.dvfu.imct.backend.model.dto.NoteCreateDTO;
import ru.dvfu.imct.backend.model.dto.NoteResponseDTO;
import ru.dvfu.imct.backend.service.NoteService;
import ru.dvfu.imct.backend.mapper.NoteMapper;

import java.util.List;

@RestController
public class NoteController implements NoteControllerApi {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @Override
    public List<NoteResponseDTO> getAllNotes() {
        return noteService.getAllNotes().stream()
                .map(NoteMapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<NoteResponseDTO> getCompletedNotes() {
        return noteService.getCompletedNotes().stream()
                .map(NoteMapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<NoteResponseDTO> search(String keyword) {
        return noteService.getNoteByKeyword(keyword).stream()
                .map(NoteMapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<NoteResponseDTO> getNotesByFolder(Long folderId, Long userId) {
        return noteService.getNotesByFolderAndUser(folderId, userId).stream()
                .map(NoteMapper::toResponseDTO)
                .toList();
    }

    @Override
    public NoteResponseDTO getNoteById(Long id) {
        return NoteMapper.toResponseDTO(noteService.getNoteById(id));
    }

    @Override
    public NoteResponseDTO createNote(NoteCreateDTO noteCreateDto) {
        return NoteMapper.toResponseDTO(noteService.createNote(noteCreateDto));
    }

    @Override
    public NoteResponseDTO updateNote(Long id, NoteCreateDTO noteDto) {
        return NoteMapper.toResponseDTO(noteService.updateNote(id, noteDto));
    }

    @Override
    public void deleteNote(Long id) {
        noteService.deleteNote(id);
    }
}

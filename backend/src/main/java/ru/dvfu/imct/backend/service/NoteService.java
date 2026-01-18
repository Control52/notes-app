package ru.dvfu.imct.backend.service;

import org.springframework.boot.jdbc.autoconfigure.ApplicationDataSourceScriptDatabaseInitializer;
import org.springframework.stereotype.Service;
import ru.dvfu.imct.backend.model.dto.NoteCreateDTO;
import ru.dvfu.imct.backend.exception.NotFoundException;
import ru.dvfu.imct.backend.model.entity.Folder;
import ru.dvfu.imct.backend.model.entity.Note;
import ru.dvfu.imct.backend.repository.NoteRepository;
import ru.dvfu.imct.backend.model.entity.User;
import ru.dvfu.imct.backend.repository.TagRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final TagRepository tagRepository;

    public NoteService(NoteRepository noteRepository, TagRepository tagRepository,
            ApplicationDataSourceScriptDatabaseInitializer dataSourceScriptDatabaseInitializer) {
        this.noteRepository = noteRepository;
        this.tagRepository = tagRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Заметка с id=" + id + " не найдена"));
    }

    public Note createNote(NoteCreateDTO dto) {
        Note note = new Note();
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        note.setIsCompleted(false);
        note.setCreatedAt(LocalDateTime.now());
        note.setUpdateAt(LocalDateTime.now());

        User user = new User();
        user.setId(dto.getUserId());
        note.setUser(user);

        if (dto.getFolderId() != null) {
            Folder folder = new Folder();
            folder.setId(dto.getFolderId());
            note.setFolder(folder);
        }

        if (dto.getTagIds() != null && !dto.getTagIds().isEmpty()) {
            var tags = tagRepository.findAllById(dto.getTagIds());
            note.setTags(new java.util.HashSet<>(tags));
        }

        return noteRepository.save(note);
    }

    public Note updateNote(Long id, NoteCreateDTO dto) {
        Note existingNote = noteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Заметка с id=" + id + " не найдена"));
        existingNote.setTitle(dto.getTitle());
        existingNote.setContent(dto.getContent());
        existingNote.setUpdateAt(LocalDateTime.now());
        if (dto.getTagIds() != null) {
            var tags = tagRepository.findAllById(dto.getTagIds());
            existingNote.setTags(new java.util.HashSet<>(tags));
        }
        return noteRepository.save(existingNote);
    }


    public void deleteNote(Long id) {
        if (!noteRepository.existsById(id)) {
            throw new NotFoundException("Заметка с id=" + id + " не найдена");
        }
        noteRepository.deleteById(id);
    }

    public List<Note> getCompletedNotes() {
        return noteRepository.findAllByIsCompletedTrue();
    }

    public List<Note> getNoteByKeyword(String keyword) {
        return noteRepository.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(keyword, keyword);
    }

    public List<Note> getNotesByFolderAndUser(Long folderId, Long userId) {
        return noteRepository.findByFolderIdAndUserId(folderId, userId);
    }
}

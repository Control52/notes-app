package ru.dvfu.imct.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dvfu.imct.backend.model.entity.Note;
import ru.dvfu.imct.backend.model.entity.User;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByUser(User user);

    List<Note> findByFolderIdAndUserId(Long folderId, Long userId);

    List<Note> findByUserAndIsCompletedFalse(User user);

    List<Note> findByTitleContainingIgnoreCase(String title);

    List<Note> findAllByIsCompletedTrue();

    List<Note> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String title, String content);


}
package ru.dvfu.imct.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dvfu.imct.backend.model.entity.Folder;
import ru.dvfu.imct.backend.model.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {

    List<Folder> findByUserId(Long userId);

    Optional<Folder> findByTitleAndUser(String title, User user);

    boolean existsByTitleAndUser(String title, User user);
}
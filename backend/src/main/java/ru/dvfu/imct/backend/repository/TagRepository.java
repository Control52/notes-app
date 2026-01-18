package ru.dvfu.imct.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dvfu.imct.backend.model.entity.Tag;
import ru.dvfu.imct.backend.model.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findByUser(User user);

    Optional<Tag> findByTitleAndUser(String title, User user);

    boolean existsByTitleAndUser(String title, User user);
}
package ru.dvfu.imct.backend.service;

import org.springframework.stereotype.Service;
import ru.dvfu.imct.backend.model.dto.TagCreateDTO;
import ru.dvfu.imct.backend.model.entity.Tag;
import ru.dvfu.imct.backend.model.entity.User;
import ru.dvfu.imct.backend.repository.TagRepository;

import java.util.List;
import ru.dvfu.imct.backend.exception.NotFoundException;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getTagsByUser(Long userId) {
        User user = new User();
        user.setId(userId);
        return tagRepository.findByUser(user);
    }

    public Tag createTag(TagCreateDTO tagCreateDTO) {
        Tag tag = new Tag();
        tag.setTitle(tagCreateDTO.getTitle());
        User user = new User();
        user.setId(tagCreateDTO.getUserId());
        tag.setUser(user);
        return tagRepository.save(tag);
    }

    public void deleteTag(Long tagId) {
        if (!tagRepository.existsById(tagId)) {
            throw new NotFoundException("Тег с id" + tagId + " не найден");
        }
        tagRepository.deleteById(tagId);
    }
}

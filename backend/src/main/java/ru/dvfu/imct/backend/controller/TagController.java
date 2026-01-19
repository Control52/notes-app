package ru.dvfu.imct.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.dvfu.imct.backend.controller.api.TagControllerApi;
import ru.dvfu.imct.backend.model.dto.TagDTO;
import ru.dvfu.imct.backend.model.dto.TagCreateDTO;
import ru.dvfu.imct.backend.service.TagService;
import ru.dvfu.imct.backend.mapper.TagMapper;

import java.util.List;

@RestController
public class TagController implements TagControllerApi {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @Override
    public List<TagDTO> getTagsByUser(Long userId) {
        return tagService.getTagsByUser(userId).stream().map(TagMapper::toDTO).toList();
    }

    @Override
    public TagDTO createTag(TagCreateDTO tagCreateDTO) {
        return TagMapper.toDTO(tagService.createTag(tagCreateDTO));
    }

    @Override
    public void deleteTag(Long tagId) {
        tagService.deleteTag(tagId);
    }
}

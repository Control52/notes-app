package ru.dvfu.imct.backend.mapper;

import ru.dvfu.imct.backend.model.dto.TagDTO;
import ru.dvfu.imct.backend.model.entity.Tag;

public class TagMapper {
    public static TagDTO toDTO(Tag tag) {
        if (tag == null)
            return null;
        TagDTO dto = new TagDTO();
        dto.setId(tag.getId());
        dto.setTitle(tag.getTitle());
        return dto;
    }
}

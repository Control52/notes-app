package ru.dvfu.imct.backend.mapper;

import ru.dvfu.imct.backend.model.dto.NoteResponseDTO;
import ru.dvfu.imct.backend.model.entity.Note;
import ru.dvfu.imct.backend.model.dto.TagDTO;
import java.util.Set;
import java.util.stream.Collectors;

public class NoteMapper {

    public static NoteResponseDTO toResponseDTO(Note note) {
        if (note == null)
            return null;

        NoteResponseDTO dto = new NoteResponseDTO();
        dto.setId(note.getId());
        dto.setTitle(note.getTitle());
        dto.setContent(note.getContent());
        dto.setCreatedAt(note.getCreatedAt());

        if (note.getUser() != null) {
            dto.setUserId(note.getUser().getId());
            dto.setUsername(note.getUser().getUsername());
        }

        if (note.getFolder() != null) {
            dto.setFolderId(note.getFolder().getId());
            dto.setFolderTitle(note.getFolder().getTitle());
        }

        if (note.getTags() != null) {
            Set<TagDTO> tagDTOs = note.getTags().stream()
                    .map(TagMapper::toDTO)
                    .collect(Collectors.toSet());
            dto.setTags(tagDTOs);
        }
        return dto;
    }
}

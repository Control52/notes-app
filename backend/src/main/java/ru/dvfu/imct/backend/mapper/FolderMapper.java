package ru.dvfu.imct.backend.mapper;

import ru.dvfu.imct.backend.model.dto.FolderResponseDTO;
import ru.dvfu.imct.backend.model.entity.Folder;

public class FolderMapper {
    public static FolderResponseDTO toResponseDTO(Folder folder) {
        if (folder == null)
            return null;
        FolderResponseDTO dto = new FolderResponseDTO();
        dto.setId(folder.getId());
        dto.setTitle(folder.getTitle());
        if (folder.getUser() != null) {
            dto.setUserId(folder.getUser().getId());
        }
        return dto;
    }
}

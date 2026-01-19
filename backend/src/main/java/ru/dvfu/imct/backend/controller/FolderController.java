package ru.dvfu.imct.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.dvfu.imct.backend.controller.api.FolderControllerApi;
import ru.dvfu.imct.backend.model.dto.FolderCreateDTO;
import ru.dvfu.imct.backend.model.dto.FolderResponseDTO;
import ru.dvfu.imct.backend.mapper.FolderMapper;
import ru.dvfu.imct.backend.service.FolderService;

@RestController
public class FolderController implements FolderControllerApi {
    private final FolderService folderService;

    public FolderController(FolderService folderService) {
        this.folderService = folderService;
    }

    @Override
    public FolderResponseDTO create(FolderCreateDTO folderCreateDto) {
        return FolderMapper.toResponseDTO(folderService.createFolder(folderCreateDto));
    }

    @Override
    public FolderResponseDTO getById(Long id) {
        return FolderMapper.toResponseDTO(folderService.getById(id));
    }
}

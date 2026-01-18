package ru.dvfu.imct.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.dvfu.imct.backend.model.dto.FolderCreateDTO;
import ru.dvfu.imct.backend.model.dto.FolderResponseDTO;
import ru.dvfu.imct.backend.mapper.FolderMapper;
import ru.dvfu.imct.backend.service.FolderService;

@RestController
@RequestMapping("/api/folders")
@Tag(name = "Папки", description = "Управление папками")
public class FolderController {
    private final FolderService folderService;

    public FolderController(FolderService folderService) {
        this.folderService = folderService;
    }

    @Operation(summary = "создание папки")
    @PostMapping
    public FolderResponseDTO create(@RequestBody FolderCreateDTO folderCreateDto) {
        return FolderMapper.toResponseDTO(folderService.createFolder(folderCreateDto));
    }

    @Operation(summary = "Получить папку по id")
    @GetMapping("/{id}")
    public FolderResponseDTO getById(@PathVariable Long id) {
        return FolderMapper.toResponseDTO(folderService.getById(id));
    }
}

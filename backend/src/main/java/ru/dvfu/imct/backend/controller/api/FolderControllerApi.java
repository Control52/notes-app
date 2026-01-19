package ru.dvfu.imct.backend.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.dvfu.imct.backend.model.dto.FolderCreateDTO;
import ru.dvfu.imct.backend.model.dto.FolderResponseDTO;

@RequestMapping("/api/folders")
@Tag(name = "Папки", description = "Управление папками")
public interface FolderControllerApi {

    @Operation(summary = "создание папки")
    @PostMapping
    FolderResponseDTO create(@RequestBody FolderCreateDTO folderCreateDto);

    @Operation(summary = "Получить папку по id")
    @GetMapping("/{id}")
    FolderResponseDTO getById(@PathVariable Long id);
}

package ru.dvfu.imct.backend.service;

import org.springframework.stereotype.Service;
import ru.dvfu.imct.backend.model.dto.FolderCreateDTO;
import ru.dvfu.imct.backend.model.entity.Folder;
import ru.dvfu.imct.backend.model.entity.User;
import ru.dvfu.imct.backend.repository.FolderRepository;

import ru.dvfu.imct.backend.exception.NotFoundException;

@Service
public class FolderService {
    private final FolderRepository folderRepository;

    public FolderService(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    public Folder createFolder(FolderCreateDTO folderCreateDto) {
        Folder folder = new Folder();
        folder.setTitle(folderCreateDto.getTitle());

        User user = new User();
        user.setId(folderCreateDto.getUserId());
        folder.setUser(user);

        return folderRepository.save(folder);

    }

    public Folder getById(Long id) {
        return folderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Папка с id=" + id + " не найдена"));
    }
}

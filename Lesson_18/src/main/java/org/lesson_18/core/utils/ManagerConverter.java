package org.lesson_18.core.utils;


import org.lesson_18.dto.manager.ManagerCreateRequestDTO;
import org.lesson_18.dto.manager.ManagerCreateResponseDTO;
import org.lesson_18.dto.manager.ManagerResponseDTO;
import org.lesson_18.entity.Manager;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class ManagerConverter {

    public ManagerCreateResponseDTO toCreateDto(Manager manager) {
        return new ManagerCreateResponseDTO(manager.getId(), manager.getManagerName(), LocalDateTime.now(),LocalDateTime.now());
    }

    public ManagerResponseDTO toDto(Manager manager) {
        return new ManagerResponseDTO(manager.getId(), manager.getManagerName(), manager.getEmail(),LocalDateTime.now(),LocalDateTime.now());
    }

    public Manager fromDto(ManagerCreateRequestDTO dto) {
        Manager newManager = new Manager();
        if (dto.getManagerName() != null) {
            newManager.setManagerName(dto.getManagerName());
        }
        if (dto.getPassword() != null) {
            newManager.setPassword(dto.getPassword());
        }
        if (dto.getEmail() != null) {
            newManager.setEmail(dto.getEmail());
        }

        return newManager;
    }
}

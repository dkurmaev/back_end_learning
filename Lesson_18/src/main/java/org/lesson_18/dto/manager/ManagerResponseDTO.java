package org.lesson_18.dto.manager;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ManagerResponseDTO {

    private Integer id;
    private String managerName;
    private String email;
    private LocalDateTime createManagerDate;
    private LocalDateTime lastUpdate;

}

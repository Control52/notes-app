
package ru.dvfu.imct.backend.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ответ с ошибкой")
public class ErrorResponseDTO {
    @Schema(description = "Сообщение об ошибке")
    private String message;

    public ErrorResponseDTO() {
    }

    public ErrorResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

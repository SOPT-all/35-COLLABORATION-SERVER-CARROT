package com.sopt.carrot_server.global.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

@Builder
public record ErrorResponse(
        int status,
        String message,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        List<ValidationError> errors
) {
    public static ErrorResponse of(int status, String message){
        return ErrorResponse.builder()
                .status(status)
                .message(message)
                .build();
    }

    public static ErrorResponse of(int status, String message, BindingResult bindingResult){
        return ErrorResponse.builder()
                .status(status)
                .message(message)
                .errors(ValidationError.of(bindingResult))
                .build();
    }

    @Getter
    public static class ValidationError {
        private final String field;
        private final String message;

        private ValidationError(FieldError fieldError){
            this.field = fieldError.getField();
            this.message = fieldError.getDefaultMessage();
        }

        public static List<ValidationError> of(final BindingResult bindingResult){
            return bindingResult.getFieldErrors().stream()
                    .map(ValidationError::new)
                    .toList();
        }
    }
}

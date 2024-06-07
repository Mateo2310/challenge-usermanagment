package com.exercises.usermanagement.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponseErrorDTO implements Serializable {
    private String message;
    public ResponseErrorDTO(String message) {
        this.message = message;
    }

    public ResponseErrorDTO() {
    }
}

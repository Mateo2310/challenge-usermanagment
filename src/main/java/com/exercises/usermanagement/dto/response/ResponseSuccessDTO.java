package com.exercises.usermanagement.dto.response;

import com.exercises.usermanagement.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class ResponseSuccessDTO implements Serializable {
    private String id;
    private String created;
    private String updated;
    private String lastLogin;
    private String token;
    private boolean isActive;

    public ResponseSuccessDTO() {}

    public ResponseSuccessDTO(String id, String created, String updated, String lastLogin, String token, boolean isActive) {
        this.id = id;
        this.created = created;
        this.updated = updated;
        this.lastLogin = lastLogin;
        this.token = token;
        this.isActive = isActive;
    }
}

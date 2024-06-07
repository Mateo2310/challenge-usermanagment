package com.exercises.usermanagement.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class UserRegistrationDTO implements Serializable {
    private String name;
    private String email;
    private String password;
    private List<PhoneRegisterDTO> phones;
}

package com.exercises.usermanagement.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PhoneRegisterDTO implements Serializable {
    private String number;
    private String cityCode;
    private String countryCode;
}

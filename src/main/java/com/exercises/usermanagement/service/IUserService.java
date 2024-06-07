package com.exercises.usermanagement.service;

import com.exercises.usermanagement.dto.request.UserRegistrationDTO;
import com.exercises.usermanagement.dto.response.ResponseSuccessDTO;

public interface IUserService {
    ResponseSuccessDTO registerUser(UserRegistrationDTO userRegistrationDTO);
    ResponseSuccessDTO updateUser(UserRegistrationDTO userRegistrationDTO);
}

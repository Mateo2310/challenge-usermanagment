package com.exercises.usermanagement.service;

import com.exercises.usermanagement.dto.request.UserRegistrationDTO;
import com.exercises.usermanagement.dto.response.ResponseSuccessDTO;
import com.exercises.usermanagement.entity.Phone;
import com.exercises.usermanagement.entity.User;
import com.exercises.usermanagement.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository iUserRepository;

    private final IPhoneService iPhoneService;

    public UserServiceImpl(IUserRepository iUserRepository, IPhoneService iPhoneService) {
        this.iUserRepository = iUserRepository;
        this.iPhoneService = iPhoneService;
    }

    @Override
    public ResponseSuccessDTO registerUser(UserRegistrationDTO userRegistrationDTO) {
        User userEntity = this.convertUserDTOToUser(userRegistrationDTO);
        User savedUser = this.iUserRepository.save(userEntity);

        return this.convertToResponseSuccessDTO(savedUser);
    }

    @Override
    public ResponseSuccessDTO updateUser(UserRegistrationDTO userRegistrationDTO) {
        User user = this.iUserRepository.getUserByEmail(userRegistrationDTO.getEmail());
        user.setName(userRegistrationDTO.getName());
        user.setEmail(userRegistrationDTO.getEmail());
        user.setPhones(this.iPhoneService.updatePhones(userRegistrationDTO.getPhones(), user.getPhones()));
        user.setPassword(userRegistrationDTO.getPassword());
        user.setUpdatedAt(new Date());
        return this.convertToResponseSuccessDTO(this.iUserRepository.save(user));
    }

    @Override
    public ResponseSuccessDTO getUser(String email) {
        User user = this.iUserRepository.getUserByEmail(email);
        return this.convertToResponseSuccessDTO(user);
    }

    private User convertUserDTOToUser(UserRegistrationDTO userRegistrationDTO) {
        List<Phone> phones = this.iPhoneService.registerPhones(userRegistrationDTO.getPhones());
        Date today = new Date();
        return new User(
                userRegistrationDTO.getName(),
                userRegistrationDTO.getEmail(),
                userRegistrationDTO.getPassword(),
                phones,
                true,
                today,
                today
        );
    }

    private String dateToString(Date dateToConvert) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return sdf.format(dateToConvert);
    }

    private ResponseSuccessDTO convertToResponseSuccessDTO(User user){
        String createdAtString = this.dateToString(user.getCreatedAt());
        String updatedAtString = this.dateToString(user.getUpdatedAt());

        return new ResponseSuccessDTO(
                user.getId().toString(),
                createdAtString,
                updatedAtString,
                updatedAtString,
                "tokenTest",
                user.isActive()
        );
    }


}

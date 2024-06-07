package com.exercises.usermanagement.service;

import com.exercises.usermanagement.dto.request.PhoneRegisterDTO;
import com.exercises.usermanagement.entity.Phone;

import java.util.List;

public interface IPhoneService {
    Phone registerPhone(PhoneRegisterDTO phoneRegisterDTO);
    List<Phone> registerPhones(List<PhoneRegisterDTO> phoneRegisterDTOList);
    List<Phone> updatePhones(List<PhoneRegisterDTO> phoneRegisterDTOList, List<Phone> phonesEntities);
}

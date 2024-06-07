package com.exercises.usermanagement.service;

import com.exercises.usermanagement.dto.request.PhoneRegisterDTO;
import com.exercises.usermanagement.entity.Phone;
import com.exercises.usermanagement.repository.IPhoneRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PhoneServiceImpl implements IPhoneService {

    private final IPhoneRepository iPhoneRepository;

    public PhoneServiceImpl(IPhoneRepository iPhoneRepository) {
        this.iPhoneRepository = iPhoneRepository;
    }

    @Override
    public Phone registerPhone(PhoneRegisterDTO phoneRegisterDTO) {
        Phone phone = this.convertPhoneDTOToPhone(phoneRegisterDTO);
        return this.iPhoneRepository.save(phone);
    }

    @Override
    public List<Phone> registerPhones(List<PhoneRegisterDTO> phoneRegisterDTOList) {
        List<Phone> phones = phoneRegisterDTOList.stream()
                .map(this::convertPhoneDTOToPhone)
                .toList();
        this.iPhoneRepository.saveAll(phones);

        return phones;
    }

    private Phone convertPhoneDTOToPhone(PhoneRegisterDTO phoneRegisterDTO) {
        Date today = new Date();
        return new Phone(
                phoneRegisterDTO.getNumber(),
                phoneRegisterDTO.getCityCode(),
                phoneRegisterDTO.getCountryCode(),
                today,
                today
        );
    }
}

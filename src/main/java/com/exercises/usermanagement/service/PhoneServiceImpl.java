package com.exercises.usermanagement.service;

import com.exercises.usermanagement.dto.request.PhoneRegisterDTO;
import com.exercises.usermanagement.entity.Phone;
import com.exercises.usermanagement.repository.IPhoneRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
                .collect(Collectors.toList());
        this.iPhoneRepository.saveAll(phones);

        return phones;
    }

    @Override
    public List<Phone> updatePhones(List<PhoneRegisterDTO> phoneRegisterDTOList, List<Phone> phonesEntities) {
        return this.iPhoneRepository.saveAll(
                this.convertToPhones(
                        phoneRegisterDTOList,
                        phonesEntities
                )
        );
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

    private List<Phone> convertToPhones(List<PhoneRegisterDTO> phonesDTO, List<Phone> phones) {
        List<Phone> phoneToReturn = new ArrayList<>();
        for (Phone phone : phones) {
            for (PhoneRegisterDTO phoneRegisterDTO : phonesDTO) {
                if (phone.getNumber().equals(phoneRegisterDTO.getNumber())) {
                    phoneToReturn.add(this.convertToSinglePhone(phoneRegisterDTO, phone));
                }
            }
        }

        return phoneToReturn;
    }

    private Phone convertToSinglePhone(PhoneRegisterDTO phoneDTO, Phone phoneEntity) {
        phoneEntity.setCityCode(phoneDTO.getCityCode());
        phoneEntity.setNumber(phoneDTO.getNumber());
        phoneEntity.setUpdatedAt(new Date());
        phoneEntity.setCountryCode(phoneDTO.getCountryCode());
        return phoneEntity;
    }
}

package com.technology.registration.services.address;

import com.technology.registration.dto.input.UserDto;
import com.technology.registration.models.Address;
import com.technology.registration.registration.requests.AddressRegistrationRequest;
import com.technology.registration.repositories.AddressRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{
    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    @Transactional
    public Address registerUserAddress(AddressRegistrationRequest addressRegistrationRequest) {
        Address address = new Address();
        address.setRegion(addressRegistrationRequest.region());
        address.setDistrict(addressRegistrationRequest.district());
        address.setLocality(addressRegistrationRequest.locality());
        address.setStreet(addressRegistrationRequest.street());
        address.setPremise(addressRegistrationRequest.premise());
        address.setZipcode(addressRegistrationRequest.zipcode());
        addressRepository.save(address);
        return address;
    }
}

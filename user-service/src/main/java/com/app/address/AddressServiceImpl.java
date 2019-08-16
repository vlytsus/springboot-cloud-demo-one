package com.app.address;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Slf4j
@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void saveAddress(AddressEntity address) {
        log.debug("Save UserAddress : " + address);
        addressRepository.save(address);
    }

    @Override
    public Collection<AddressEntity> getAddresses() {
        Collection<AddressEntity> addresses = new ArrayList<>();
        addressRepository.findAll().forEach(addresses::add);
        log.debug("Get all UserAddresses : " + addresses);
        return addresses;
    }

    @Override
    public AddressEntity getAddressById(UUID id) {
        AddressEntity address = addressRepository.findById(id).get();
        log.debug("Get UserAddress by Id : " + address);
        return address;
    }
}

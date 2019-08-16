package com.app.address;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping(path = "/")
    public void createAddress(@RequestBody AddressEntity address) {
        addressService.saveAddress(address);
    }

    @GetMapping(path = "/")
    public Collection<AddressEntity> getAddresses() {
        return addressService.getAddresses();
    }

    @GetMapping(path = "/id/{id}")
    public AddressEntity getAddressById(@PathVariable("id") String id) {
        UUID uuid = UUID.fromString(id);
        return addressService.getAddressById(uuid);
    }


}

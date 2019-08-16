package com.app.address;

import java.util.Collection;
import java.util.UUID;

public interface AddressService {

    void saveAddress(AddressEntity address);
    Collection<AddressEntity> getAddresses();
    AddressEntity getAddressById(UUID id);


}

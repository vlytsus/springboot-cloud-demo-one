package com.app.address;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, UUID> {

}

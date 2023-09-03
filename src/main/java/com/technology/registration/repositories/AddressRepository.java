package com.technology.registration.repositories;

import com.technology.registration.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface AddressRepository extends JpaRepository<Address, BigInteger> {
}

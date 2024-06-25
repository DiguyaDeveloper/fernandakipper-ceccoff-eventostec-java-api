package com.eventostec.ceccoff.api.repository;

import com.eventostec.ceccoff.api.domain.address.Address;
import com.eventostec.ceccoff.api.domain.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}

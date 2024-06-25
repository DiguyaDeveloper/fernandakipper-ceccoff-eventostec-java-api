package com.eventostec.ceccoff.api.repository;

import com.eventostec.ceccoff.api.domain.coupon.Coupon;
import com.eventostec.ceccoff.api.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CouponRepository extends JpaRepository<Coupon, UUID> {
}

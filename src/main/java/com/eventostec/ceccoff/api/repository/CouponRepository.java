package com.eventostec.ceccoff.api.repository;

import com.eventostec.ceccoff.api.domain.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface CouponRepository extends JpaRepository<Coupon, UUID> {

    List<Coupon> findByEventIdAndValidAfter(UUID eventId, LocalDateTime currentDate);
}

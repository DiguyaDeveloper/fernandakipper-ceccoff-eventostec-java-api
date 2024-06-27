package com.eventostec.ceccoff.api.repository;

import com.eventostec.ceccoff.api.domain.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface CouponRepository extends JpaRepository<Coupon, UUID> {

    @Query("SELECT e FROM Coupon e LEFT JOIN FETCH e.event a " +
            "WHERE e.validFrom >= :validFrom " +
            "AND e.expireIn < :expireIn " +
            "AND a.id = :eventId ")
    List<Coupon> findByEventIdAndValidFromLessThanEqualAndExpireInGreaterThanEqual(UUID eventId, LocalDate validFrom, LocalDate expireIn);

}

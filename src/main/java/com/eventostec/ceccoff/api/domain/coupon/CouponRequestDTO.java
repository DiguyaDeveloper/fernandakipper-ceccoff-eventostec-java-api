package com.eventostec.ceccoff.api.domain.coupon;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record CouponRequestDTO(
        String code,
        Integer discount,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate expireIn,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate validFrom) {
}

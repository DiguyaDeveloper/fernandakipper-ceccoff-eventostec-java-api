package com.eventostec.ceccoff.api.controller;

import com.eventostec.ceccoff.api.domain.coupon.Coupon;
import com.eventostec.ceccoff.api.domain.coupon.CouponRequestDTO;
import com.eventostec.ceccoff.api.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/event/{eventId}")
    public ResponseEntity<Coupon> addCouponToEvent(
            @PathVariable UUID eventId,
            @RequestBody CouponRequestDTO request
    ) {
        Coupon coupons = couponService.addCouponToEvent(eventId, request);

        return ResponseEntity.ok(coupons);
    }
}

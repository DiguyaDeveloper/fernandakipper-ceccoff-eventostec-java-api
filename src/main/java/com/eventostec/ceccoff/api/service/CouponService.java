package com.eventostec.ceccoff.api.service;

import com.eventostec.ceccoff.api.domain.coupon.Coupon;
import com.eventostec.ceccoff.api.domain.coupon.CouponRequestDTO;
import com.eventostec.ceccoff.api.domain.event.Event;
import com.eventostec.ceccoff.api.repository.CouponRepository;
import com.eventostec.ceccoff.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private EventRepository eventRepository;

    public Coupon addCouponToEvent(UUID eventId, CouponRequestDTO request) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        Coupon coupon = new Coupon();
        coupon.setCode(request.code());
        coupon.setDiscount(request.discount());
        coupon.setExpireIn(request.expireIn());
        coupon.setValidFrom(request.validFrom());
        coupon.setEvent(event);

        return couponRepository.save(coupon);
    }

    public List<Coupon> getCouponsOfEvent(UUID eventId, LocalDate currentDate) {
        return couponRepository.findByEventIdAndValidFromLessThanEqualAndExpireInGreaterThanEqual(eventId, currentDate, currentDate);
    }

}

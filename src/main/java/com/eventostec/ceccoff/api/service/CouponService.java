package com.eventostec.ceccoff.api.service;

import com.eventostec.ceccoff.api.domain.coupon.Coupon;
import com.eventostec.ceccoff.api.domain.coupon.CouponRequestDTO;
import com.eventostec.ceccoff.api.domain.event.Event;
import com.eventostec.ceccoff.api.repository.CouponRepository;
import com.eventostec.ceccoff.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
        coupon.setValid(new Date(request.valid()));
        coupon.setEvent(event);

        return couponRepository.save(coupon);
    }

    public List<Coupon> getCouponsOfEvent(UUID eventId, LocalDateTime currentDate) {
        return couponRepository.findByEventIdAndValidAfter(eventId, currentDate);
    }

}

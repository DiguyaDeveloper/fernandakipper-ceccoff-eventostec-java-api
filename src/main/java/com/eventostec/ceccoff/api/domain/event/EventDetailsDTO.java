package com.eventostec.ceccoff.api.domain.event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record EventDetailsDTO(
        UUID id,
        String title,
        String description,
        LocalDateTime date,
        String city,
        String uf,
        String imgUrl,
        String eventUrl,
        List<CouponDTO> coupons) {

    public record CouponDTO(
            String code,
            Integer discount,
            LocalDate expireIn) {
    }
}
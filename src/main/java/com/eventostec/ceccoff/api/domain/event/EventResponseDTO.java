package com.eventostec.ceccoff.api.domain.event;

import java.util.Date;
import java.util.UUID;

public record EventResponseDTO(
        UUID id,
        String title,
        String description,
        Date date,
        String city,
        String state,
        Boolean remote,
        String eventUrl,
        String imageUrl) {
}

package com.eventostec.ceccoff.api.domain.event;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

public record EventRequestDTO(
        String title,
        String description,
        LocalDateTime date,
        String city,
        String state,
        Boolean remote,
        String eventUrl,
        MultipartFile image) {
}

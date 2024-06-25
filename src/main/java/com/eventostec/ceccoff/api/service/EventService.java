package com.eventostec.ceccoff.api.service;

import com.eventostec.ceccoff.api.domain.event.Event;
import com.eventostec.ceccoff.api.domain.event.EventRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Service
public class EventService {

    public Event create(EventRequestDTO request) {
        String imgUrl = null;

        if (request.image() != null) {
            imgUrl = this.uploadImg(request.image());
        }

        Event newEvent = new Event();
        newEvent.setTitle(request.title());
        newEvent.setDescription(request.description());
        newEvent.setEventUrl(request.eventUrl());
        newEvent.setDate(new Date(request.date()));
        newEvent.setImgUrl(imgUrl);

        return newEvent;
    }

    private String uploadImg(MultipartFile file) {
        return "";
    }
}

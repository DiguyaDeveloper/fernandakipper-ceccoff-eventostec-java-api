package com.eventostec.ceccoff.api.service;

import com.eventostec.ceccoff.api.domain.event.Event;
import com.eventostec.ceccoff.api.domain.event.EventRequestDTO;
import com.eventostec.ceccoff.api.domain.event.EventResponseDTO;
import com.eventostec.ceccoff.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private FileService fileService;

    @Autowired
    private EventRepository repository;

    public Event create(EventRequestDTO request) {
        String imgUrl = null;

        if (request.image() != null) {
            imgUrl = fileService.uploadImg(request.image());
        }

        Event newEvent = new Event();
        newEvent.setTitle(request.title());
        newEvent.setDescription(request.description());
        newEvent.setEventUrl(request.eventUrl());
        newEvent.setDate(request.date());
        newEvent.setImgUrl(imgUrl);
        newEvent.setRemote(request.remote());

        repository.save(newEvent);

        return newEvent;
    }

    public List<EventResponseDTO> getUpcomingEvents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Event> eventsPage = this.repository.findUpcomingEvents(new Date(), pageable);

        return eventsPage.map(event -> new EventResponseDTO(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getDate(),
                event.getAddress() != null ? event.getAddress().getCity() : "",
                event.getAddress() != null ? event.getAddress().getUf() : "",
                event.getRemote(),
                event.getEventUrl(),
                event.getImgUrl())
        ).stream().toList();
    }


}

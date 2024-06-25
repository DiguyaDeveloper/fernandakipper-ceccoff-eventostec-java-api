package com.eventostec.ceccoff.api.repository;

import com.eventostec.ceccoff.api.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
}

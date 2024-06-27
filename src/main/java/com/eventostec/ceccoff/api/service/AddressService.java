package com.eventostec.ceccoff.api.service;

import com.eventostec.ceccoff.api.domain.address.Address;
import com.eventostec.ceccoff.api.domain.event.Event;
import com.eventostec.ceccoff.api.domain.event.EventRequestDTO;
import com.eventostec.ceccoff.api.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void create(EventRequestDTO requestDTO, Event event) {
        Address address = new Address();
        address.setCity(requestDTO.city());
        address.setUf(requestDTO.state());
        address.setEvent(event);

        addressRepository.save(address);
    }
}

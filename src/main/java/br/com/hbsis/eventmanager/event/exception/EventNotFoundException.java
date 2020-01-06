package br.com.hbsis.eventmanager.event.exception;

import javax.persistence.EntityNotFoundException;

public class EventNotFoundException extends EntityNotFoundException {
    public EventNotFoundException(Long id) {
        super("Could not find event with id: " + id);
    }
}

package br.com.hbsis.eventmanager.person.exception;

import javax.persistence.EntityNotFoundException;

public class PersonNotFoundException extends EntityNotFoundException {

    public PersonNotFoundException(Long id) {
        super("Could not find person with id " + id);
    }
}

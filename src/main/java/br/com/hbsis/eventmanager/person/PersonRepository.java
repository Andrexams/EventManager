package br.com.hbsis.eventmanager.person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {
    public List<Person> findByLastName(String lastName);
    public List<Person> findAllByGender(String gender);
}

package br.com.hbsis.eventmanager.person;

import java.util.List;


public interface IPersonService {

    public List<Person> findAll();
    public Person findById(Long id);
    public Person persist(Person person);
    public void delete(Long id);

}

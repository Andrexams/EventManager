package br.com.hbsis.eventmanager.person;

import br.com.hbsis.eventmanager.common.AppProperties;
import br.com.hbsis.eventmanager.person.exception.PersonNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class PersonService implements IPersonService {

    private final AppProperties appProperties;
    private final PersonRepository personRepository;

    public PersonService(AppProperties appProperties, PersonRepository personRepository){
        this.appProperties = appProperties;
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        log.info(">>>> MinAge: " + appProperties.getPersonMinAge());
        return personRepository.findAll();
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @Override
    @Transactional(timeout = 10)
    public Person persist(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

}

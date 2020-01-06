package br.com.hbsis.eventmanager.person;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final IPersonService iPersonService;

    public PersonController(IPersonService iPersonService){
        this.iPersonService = iPersonService;
    }

    @GetMapping("/person")
    public List<Person> getAll(){
       return iPersonService.findAll();
    }

    @PostMapping("/person")
    public Person save(@RequestBody Person person){
        return iPersonService.persist(person);
    }

    @DeleteMapping("/person/{id}")
    public void delete(@PathVariable Long id){
        iPersonService.delete(id);
    }

    @GetMapping("/person/{id}")
    public Person getById(@PathVariable Long id){
        return iPersonService.findById(id);
    }

}

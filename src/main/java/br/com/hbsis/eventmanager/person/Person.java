package br.com.hbsis.eventmanager.person;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String lastName;

    private Date birthday;

    private String gender;

    public Person(){}

    public Person(String name, String lastName, Date birthday, String gender){
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
    }
}

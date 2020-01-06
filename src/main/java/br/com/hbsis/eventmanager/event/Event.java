package br.com.hbsis.eventmanager.event;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Data
@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String type;
    private String subType;
    private String desc;
    private Boolean finished;
    private Date date;
    private Double price;

    public Event(){}

    public Event(String name, String type, String subType, String desc, Boolean finished, Date date, Double price) {
        this.name = name;
        this.type = type;
        this.subType = subType;
        this.desc = desc;
        this.finished = finished;
        this.date = date;
        this.price = price;
    }
}

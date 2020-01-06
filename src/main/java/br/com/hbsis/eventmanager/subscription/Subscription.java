package br.com.hbsis.eventmanager.subscription;

import br.com.hbsis.eventmanager.event.Event;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Subscription {

    @Id
    private String uid;
    private Long personId;
    private String state;
    private Event event;
    private Date date;

    public Subscription(Long personId, String state, Event event, Date date) {
        this.personId = personId;
        this.state = state;
        this.date = date;
        this.event = event;
    }
}

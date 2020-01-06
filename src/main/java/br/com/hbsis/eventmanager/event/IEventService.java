package br.com.hbsis.eventmanager.event;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IEventService {
    public Event save(@RequestBody Event event);
    public void remove(@PathVariable Long id);
    public List<Event> getAll();
    public Event findById(@PathVariable Long id);
}

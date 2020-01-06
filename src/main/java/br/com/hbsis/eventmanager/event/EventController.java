package br.com.hbsis.eventmanager.event;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    private final IEventService iEventService;

    public EventController(IEventService iEventService) {
        this.iEventService = iEventService;
    }

    @PostMapping("/event")
    public Event save(@RequestBody Event event){
        return iEventService.save(event);
    }

    @DeleteMapping("/event/{id}")
    public void remove(@PathVariable Long id){
        iEventService.remove(id);
    }

    @GetMapping("/event")
    public List<Event> getAll(){
        return iEventService.getAll();
    }

    @GetMapping("/event/{id}")
    public Event findById(@PathVariable Long id){
        return iEventService.findById(id);
    }
}

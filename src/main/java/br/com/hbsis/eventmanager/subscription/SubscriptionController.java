package br.com.hbsis.eventmanager.subscription;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {

    private final ISubscriptionService iSubscriptionService;

    public SubscriptionController(ISubscriptionService iSubscriptionService){
        this.iSubscriptionService = iSubscriptionService;
    }

    @PostMapping("/subscription")
    public String newSubscription(@RequestBody Subscription subscription){
        return iSubscriptionService.newSubscription(subscription);
    }

    @GetMapping("/subscription/person/{id}")
    public List<Subscription> findAllByPersonId(@PathVariable Long id){
        return iSubscriptionService.findAllByPersonId(id);
    }
}

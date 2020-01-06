package br.com.hbsis.eventmanager.subscription;

import br.com.hbsis.eventmanager.event.Event;
import br.com.hbsis.eventmanager.event.EventRepository;
import br.com.hbsis.eventmanager.event.exception.EventNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class SubscriptionService implements ISubscriptionService {

    private final EventRepository eventRepository;
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(EventRepository eventRepository, SubscriptionRepository subscriptionRepository) {
        this.eventRepository = eventRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public String newSubscription(Subscription subscription) {

        Event event = eventRepository.findById(subscription.getEvent().getId())
                .orElseThrow(() -> new EventNotFoundException(subscription.getEvent().getId()));

        subscription.setEvent(event);
        subscription.setState("OPEN");
        subscription.setDate(new Date());
        Subscription subs = subscriptionRepository.save(subscription);

        return subs.getUid();
    }

    public List<Subscription> findAllByPersonId(Long personId){
        return subscriptionRepository.findAllByPersonId(personId);
    }
}

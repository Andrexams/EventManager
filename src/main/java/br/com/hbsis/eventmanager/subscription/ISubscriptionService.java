package br.com.hbsis.eventmanager.subscription;

import java.util.List;

public interface ISubscriptionService {
    public String newSubscription(Subscription subscription);
    public List<Subscription> findAllByPersonId(Long personId);
}

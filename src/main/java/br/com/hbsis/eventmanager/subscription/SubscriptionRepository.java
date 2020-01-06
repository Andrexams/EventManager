package br.com.hbsis.eventmanager.subscription;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SubscriptionRepository extends MongoRepository<Subscription,String> {
    public List<Subscription> findAllByPersonId(Long personId);
}

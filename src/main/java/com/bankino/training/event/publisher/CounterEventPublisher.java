package com.bankino.training.event.publisher;

import com.bankino.training.domain.Counter;
import com.bankino.training.event.CounterEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class CounterEventPublisher implements ApplicationEventPublisherAware {

@Autowired
private ApplicationEventPublisher publisher;


public void setApplicationEventPublisher (ApplicationEventPublisher publisher) {
	this.publisher = publisher;
}

public void publish(final String message, final Counter counter) {
	System.out.println("Publishing counter event.");
	CounterEvent ce = new CounterEvent(this,message,counter);
	publisher.publishEvent(ce);
}
}


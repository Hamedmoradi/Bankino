package com.bankino.training.event;

import com.bankino.training.domain.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;

public class CounterEvent extends ApplicationEvent {
private static final long serialVersionUID = 1L;

private String message;
@Autowired
private Counter counter;

public CounterEvent(Object source, String message, Counter counter) {
	super(source);
	this.message = message;
	this.counter = counter;
}

public String getMessage() {
	return message;
}

public Counter getCounter() {
	return counter;
}
@Override
public String toString() {
	return "My Counter Event";
}

}

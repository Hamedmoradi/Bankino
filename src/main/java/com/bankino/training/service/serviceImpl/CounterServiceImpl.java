package com.bankino.training.service.serviceImpl;

import com.bankino.training.domain.Counter;
import com.bankino.training.event.publisher.CounterEventPublisher;
import com.bankino.training.repository.CounterRepository;
import com.bankino.training.service.CounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CounterServiceImpl implements CounterService, ApplicationEventPublisherAware {

public static final Logger logger = LoggerFactory.getLogger(CounterServiceImpl.class);
@Autowired
private CounterRepository counterRepository;

@Autowired
private ApplicationEventPublisher publisher;

@Autowired
private CounterEventPublisher counterEventPublisher;


@EventListener
@Override
public Optional<Counter> getById(Long id) {
	Optional<Counter> optionalCounter = counterRepository.findById(id);
	if (optionalCounter.isPresent()) {
		return optionalCounter;
	} else {
		return Optional.empty();
	}
}

@Override
public List<Counter> getAll() {
	return counterRepository.findAll();
}

@Transactional
@Override
public Counter create(Counter counter) {
	Counter savedCounter = counterRepository.save(counter);
	logger.info("Publishing counter event.");
	publisher.publishEvent(savedCounter);
	counterEventPublisher.publish("counter ready for save", savedCounter);
	return savedCounter;
}

@Override
public void delete(Long counterId) {
	counterRepository.deleteById(counterId);
}

@Override
public Optional<Counter> getCounterByCounterNo(Counter counter) {
	Optional<Counter> counterByCounterNo = Optional.ofNullable(counterRepository.findCustomerByCounterNo(counter.getCounterNo()));
	if (counterByCounterNo.isPresent()) {
		return counterByCounterNo;
	} else {
		return Optional.empty();
	}
}

@Override
public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
	this.publisher = publisher;
}
}




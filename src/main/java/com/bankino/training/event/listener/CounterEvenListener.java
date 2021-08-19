package com.bankino.training.event.listener;

import com.bankino.training.domain.Log;
import com.bankino.training.enums.ActionType;
import com.bankino.training.enums.ServiceName;
import com.bankino.training.event.CounterEvent;
import com.bankino.training.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

public class CounterEvenListener implements ApplicationListener<CounterEvent> {

public static final Logger logger = LoggerFactory.getLogger(CounterEvenListener.class);
@Autowired
private LogService logService;


@Override
public void onApplicationEvent(CounterEvent event) {
	logger.info("counter " + event.getMessage() + " with details : " + event.getCounter());
	Log log = new Log();
	log.setCounterId(event.getCounter());
	log.setContent("json");
	log.setServiceName(ServiceName.CUSTOMER_REGISTRATION.getName());
	log.setAction(ActionType.INSERT.getType());
	log.setSuccessRate(true);
	logService.save(log);
	
}

@TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
public void handleCustom(CounterEvent event) {
	logger.info("Handling event inside a transaction BEFORE COMMIT.");
	
}

}

package org.java.full.stack.spring.io.scheduling;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RecurringTask {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Scheduled(fixedDelay = 5000)
	public void toRun() {
		log.info("recurring task running @ " + new Date());
	}
}

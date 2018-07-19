package com.yui.boot.schedule;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {

	@Scheduled(fixedDelay=5000)
	public void task() {
		System.out.println("开始定时："+new Date());
	}
}

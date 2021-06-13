package com.example.demo.event;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.demo.executorTasks.SaveMatchResultTask;
import com.example.demo.repo.MatchResultRepo;
import com.example.demo.service.IMatchMapService;

@Service
public class AppStartedEventListener {

	private IMatchMapService matchMap;
	private MatchResultRepo matchResultRepo;
	
	public AppStartedEventListener(IMatchMapService _matchMap, MatchResultRepo _matchResultRepo) {
		this.matchMap = _matchMap;
		this.matchResultRepo = _matchResultRepo;
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void saveMatchResultToDB() {
		 //System.out.println(matchResultService.Test());
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleWithFixedDelay(new SaveMatchResultTask(matchMap,matchResultRepo), 1, 1, TimeUnit.SECONDS);
	}

}

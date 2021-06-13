package com.example.demo.executorTasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.MatchResult;
import com.example.demo.repo.MatchResultRepo;
import com.example.demo.service.IMatchMapService;
import com.google.gson.Gson;

public class SaveMatchResultTask implements Runnable{
	
	private IMatchMapService matchMap;
	private MatchResultRepo matchResultRepo;
	private Logger logger = LoggerFactory.getLogger(SaveMatchResultTask.class);
	
	@Autowired
	public SaveMatchResultTask(IMatchMapService map, MatchResultRepo repo) {
		this.matchMap = map;
		this.matchResultRepo = repo;
	}
	
	@Override
	public void run() {		
		if(matchMap.GetSize() > 0) {
			List<MatchResult> matches = new ArrayList<MatchResult>();
			ConcurrentHashMap<String, MatchResult> map = matchMap.GetAll();
			for(ConcurrentHashMap.Entry<String, MatchResult> entry : map.entrySet()) {
				logger.info("Succesfully saved to db: " + new Gson().toJson(entry.getValue()));
				matches.add(entry.getValue());
				matchMap.Remove(entry.getKey());
			}
			matchResultRepo.saveAll(matches);
		}
	}

}

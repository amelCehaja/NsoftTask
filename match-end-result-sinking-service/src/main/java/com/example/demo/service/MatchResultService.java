package com.example.demo.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.demo.model.MatchResult;
import com.example.demo.repo.MatchResultRepo;
import com.google.gson.Gson;

@Service
public class MatchResultService implements IMatchResultService
{
	private IMatchMapService matchMap;
	private Logger logger;
	private MatchResultRepo matchResultRepo;
	public MatchResultService(IMatchMapService _matchMap, MatchResultRepo _repo) {
		this.matchMap = _matchMap;
		this.matchResultRepo = _repo;
		this.logger = LoggerFactory.getLogger(MatchResultService.class);	
	}
	
	public MatchResult Insert(MatchResult matchResult) throws Exception {
		if(!UniqeId(matchResult.getMatchId())) {
			throw new Exception("matchId already exists!");
		}
		matchMap.AddToMap(matchResult);
		logger.info("Recived: " + new Gson().toJson(matchResult));
		return matchResult;
	}
	
	public boolean UniqeId(String id) {
		Optional<MatchResult> matchResult = matchResultRepo.findById(id);
		if(matchResult.isEmpty()) {
			return true;
		}
		return false;
	}

}

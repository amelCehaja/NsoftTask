package com.example.demo.service;

import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;
import com.example.demo.model.MatchResult;

@Service
public class MatchMapService implements IMatchMapService {
	private ConcurrentHashMap<String,MatchResult> map = new ConcurrentHashMap<>();
	
	public void AddToMap(MatchResult result) {
		map.put(result.getMatchId(), result);
	}
	
	public int GetSize() {
		return map.size();
	}
	
	public ConcurrentHashMap.Entry<String, MatchResult> GetFirst() {
		return this.map.entrySet().iterator().next();
	}
	
	public void Remove(String id) {
		this.map.remove(id);
	}

	
	public ConcurrentHashMap<String, MatchResult> GetAll() {
		return map;
	}
	
}

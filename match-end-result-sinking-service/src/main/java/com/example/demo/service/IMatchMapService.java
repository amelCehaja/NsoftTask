package com.example.demo.service;

import java.util.concurrent.ConcurrentHashMap;

import com.example.demo.model.MatchResult;

public interface IMatchMapService {
	void AddToMap(MatchResult result);
	int GetSize();
	ConcurrentHashMap.Entry<String, MatchResult> GetFirst();
	void Remove(String id);
	ConcurrentHashMap<String, MatchResult> GetAll();
}

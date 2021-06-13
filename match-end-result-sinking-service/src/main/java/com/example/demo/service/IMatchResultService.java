package com.example.demo.service;

import com.example.demo.model.MatchResult;

public interface IMatchResultService {
	MatchResult Insert(MatchResult matchResult) throws Exception;
	boolean UniqeId(String id);
}

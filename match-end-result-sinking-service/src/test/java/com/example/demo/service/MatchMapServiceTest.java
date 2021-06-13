package com.example.demo.service;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.jupiter.api.Test;

import com.example.demo.model.MatchResult;

public class MatchMapServiceTest {

	@Test
	void AddToMap() {
		MatchMapService service = new MatchMapService();		
		service.AddToMap(new MatchResult("id1","Team 1 - Team 2","0 : 0"));
		service.AddToMap(new MatchResult("id2","Team 1 - Team 2","0 : 0"));
		int size = service.GetSize();
		assertEquals(2,size);
	}
	
	@Test
	void GetFirst() {
		MatchMapService service = new MatchMapService();		
		MatchResult matchResult = new MatchResult("id1","Team 1 - Team 2","0 : 0");
		service.AddToMap(matchResult);
		ConcurrentHashMap.Entry<String, MatchResult> map = service.GetFirst();
		assertEquals("id1",map.getKey());
		MatchResult mapMatchResult = map.getValue();
		assertEquals(matchResult,mapMatchResult);
	}
	
	@Test
	void Remove() {
		MatchMapService service = new MatchMapService();		
		service.AddToMap(new MatchResult("id1","Team 1 - Team 2","0 : 0"));
		service.AddToMap(new MatchResult("id2","Team 1 - Team 2","0 : 0"));
		service.Remove("id1");
		int size = service.GetSize();
		assertEquals(1,size);
	}
}

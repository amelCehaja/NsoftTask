package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import com.example.demo.model.MatchResult;
import com.example.demo.repo.MatchResultRepo;

public class MatchResultServiceTest {

	MatchMapService matchMapService = mock(MatchMapService.class);
	MatchResultRepo matchResultRepo = mock(MatchResultRepo.class);
	MatchResultService service = new MatchResultService(matchMapService,matchResultRepo);
	
	@Test
	void UniqeIdTest() {
		MatchResult result = new MatchResult("id1","team1 - team2","0 : 1");
		when(matchResultRepo.findById("id2")).thenReturn(Optional.empty());
		boolean unique = service.UniqeId("id2");
		assertEquals(true,unique);
		
		when(matchResultRepo.findById(result.getMatchId())).thenReturn(Optional.of(result));
		unique = service.UniqeId(result.getMatchId());
		assertEquals(false,unique);
	}
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	void InsertTest() throws Exception {
		exceptionRule.expect(Exception.class);
		when(matchResultRepo.findById("id2")).thenReturn(Optional.empty());
		MatchResult result = new MatchResult("id1","team1 - team2","0 : 1");
		service.Insert(result);
	}

}

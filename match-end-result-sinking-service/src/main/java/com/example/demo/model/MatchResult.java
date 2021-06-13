package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class MatchResult 
{
	@Id
	@NotBlank()
	private String matchId;
	@NotBlank()
	private String matchName;
	@NotBlank()
	private String endResult;
	
	public MatchResult() {}
	
	public MatchResult(String id, String name, String result) {
		this.matchId = id;
		this.matchName = name;
		this.endResult = result;
	}
	
	public String getMatchId() {
		return matchId;
	}
	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	public String getMatchName() {
		return matchName;
	}
	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}
	public String getEndResult() {
		return endResult;
	}
	public void setEndResult(String endResult) {
		this.endResult = endResult;
	}
	
	@Override
	public String toString() {
		return "\"MatchResult [matchId = " + this.matchId + ",matchName = " + this.matchName + ",endResult = " + this.endResult + "]";
	}
	
}

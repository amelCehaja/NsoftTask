package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.MatchResult;

public interface MatchResultRepo extends CrudRepository<MatchResult,String>
{
	
}

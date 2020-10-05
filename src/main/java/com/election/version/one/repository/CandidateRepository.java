package com.election.version.one.repository;

import org.springframework.data.repository.CrudRepository;

import com.election.version.one.doman.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate, Integer> {
  
}

package com.election.version.one.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.election.version.one.doman.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate, Integer> {
	 @Query("Select c from Candidate c where c.cadidateid = :cadId ")
	 Optional< Candidate>  findByCandidateId(@Param("cadId") int voteCadidateid );
  
}

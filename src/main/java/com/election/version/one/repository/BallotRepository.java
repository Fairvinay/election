package com.election.version.one.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.election.version.one.doman.Ballot;

public interface BallotRepository extends CrudRepository<Ballot, Integer> {
 
}

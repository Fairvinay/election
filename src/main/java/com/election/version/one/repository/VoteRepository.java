package com.election.version.one.repository;

import org.springframework.data.repository.CrudRepository;

import com.election.version.one.doman.Vote;

public interface VoteRepository extends CrudRepository<Vote, Integer> {

}

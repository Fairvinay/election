package com.election.version.one.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.election.version.one.doman.Ballot;
import com.election.version.one.doman.VoteZoneResult;

public interface BallotResultRepository extends JpaRepository<Ballot, Integer> {

	 @Query("Select new VoteZoneResult(a.voteCadidateid  , count(distinct a.voteid )) from Ballot a  group by a.voteCadidateid ")
	 List<VoteZoneResult> findVotes();
}

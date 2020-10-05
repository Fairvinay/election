package com.election.version.one.repository;

import org.springframework.data.repository.CrudRepository;

import com.election.version.one.doman.People;

public interface PeopleRepository extends CrudRepository<People, Integer> {

}

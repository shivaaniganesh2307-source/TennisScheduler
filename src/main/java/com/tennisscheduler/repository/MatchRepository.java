package com.tennisscheduler.repository;
import com.tennisscheduler.model.Match;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Long> {}
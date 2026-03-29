package com.tennisscheduler.repository;
import com.tennisscheduler.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {}
package com.example.withfront.repo.subscriber;

import com.example.withfront.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepo extends JpaRepository<Location,Integer> {

     List<Location> findByUsernameAndServerIdIsNot(String username, Integer serverId);

     @Query("select  count (distinct l.username) from Location l")
     long countReg();


     List<Location> findAllByServerIdIsNot(Integer serverId);

     Optional<Location>  findByUsername(String username);
}

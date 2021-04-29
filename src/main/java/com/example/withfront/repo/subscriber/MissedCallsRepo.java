package com.example.withfront.repo.subscriber;

import com.example.withfront.model.MissedCalls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissedCallsRepo extends JpaRepository<MissedCalls,Integer> {
    @Override
    long count();
}

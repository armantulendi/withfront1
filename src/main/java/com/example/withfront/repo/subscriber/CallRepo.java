package com.example.withfront.repo.subscriber;

import com.example.withfront.model.Calls;
import com.example.withfront.model.Dialplan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CallRepo extends JpaRepository<Calls,Integer> {

    long countByStartTimeAfter(Date date);

    @Query("select AVG(duration) from Calls")
    float  getByStartTimeAfter();

    List<Calls> findAllByCaller1(String duration);
    @Override
    Optional<Calls> findById(Integer integer);



    List<Calls> findByStartTimeBetween(Date startTime1, Date startTime2);
    List<Calls> findByStartTimeBefore(Date startTime2);
    List<Calls> findAllByStartTimeAfter(Date startTime);
    @Query("select c from Calls c where c.startTime > current_date")
    List<Calls> findByCurrentTimeAfter();

//    Page<Calls> findPaginated(int page, int pageSize);
//    Page<Calls> findAll(Pageable pageable);
}

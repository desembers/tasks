package com.example.schedule.Reopsitory;

import com.example.schedule.entity.Comment;
import com.example.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ComponentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findBySchedule(Schedule schedule);
    int countBySchedule(Schedule schedule);

}



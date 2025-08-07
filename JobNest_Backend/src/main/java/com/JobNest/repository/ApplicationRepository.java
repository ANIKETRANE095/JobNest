package com.JobNest.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.JobNest.Entity.Application;
import com.JobNest.Entity.Job;
import com.JobNest.Entity.User;


public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByCandidate(User candidate);

    List<Application> findByJob(Job job);
}

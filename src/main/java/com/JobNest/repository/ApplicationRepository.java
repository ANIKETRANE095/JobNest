package com.JobNest.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.JobNest.Entity.Application;
import com.JobNest.Entity.Job;
import com.JobNest.Entity.User;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    // Find all applications submitted by a specific user (candidate)
    List<Application> findByUser(User user);

    // Find all applications submitted for a specific job
    List<Application> findByJob(Job job);
}

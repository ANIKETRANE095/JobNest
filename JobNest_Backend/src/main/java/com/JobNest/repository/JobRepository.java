package com.JobNest.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.JobNest.Entity.Job;
import com.JobNest.Entity.User;


public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByRecruiter(User recruiter);

    List<Job> findByTitleContainingIgnoreCase(String keyword);
}

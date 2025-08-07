package com.JobNest.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.JobNest.Entity.Job;
import com.JobNest.Entity.User;

public interface JobRepository extends JpaRepository<Job, Long> {

    // Jobs posted by specific recruiter
    List<Job> findByRecruiter(User recruiter);

    // Exact match on job title
    List<Job> findByTitle(String title);
}

package com.JobNest.services;

import java.util.List;
import com.JobNest.dto.JobDto;

public interface JobService {
    JobDto postJob(JobDto jobDTO);
    JobDto getJobById(Long id);
    List<JobDto> getAllJobs();
    JobDto updateJob(Long id, JobDto jobDTO);
    void deleteJob(Long id);
}

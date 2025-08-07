package com.JobNest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JobNest.Entity.Job;
import com.JobNest.Entity.Role;
import com.JobNest.Entity.User;
import com.JobNest.dto.JobDto;
import com.JobNest.repository.JobRepository;
import com.JobNest.repository.UserRepository;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserRepository userRepository;

    // ✅ POST job (only recruiter can post)
    @Override
    public JobDto postJob(JobDto dto) {
        User recruiter = userRepository.findById(dto.getRecruiterId())
                .orElseThrow(() -> new RuntimeException("Recruiter not found with ID: " + dto.getRecruiterId()));

        if (!recruiter.getRole().equals(Role.RECRUITER)) {
            throw new RuntimeException("User is not authorized to post jobs.");
        }

        Job job = new Job();
        job.setTitle(dto.getTitle());
        job.setDescription(dto.getDescription());
        job.setLocation(dto.getLocation());
        job.setCompanyName(dto.getCompanyName());
        job.setRecruiter(recruiter);

        Job saved = jobRepository.save(job);
        return mapToDTO(saved);
    }

    // ✅ GET job by ID
    @Override
    public JobDto getJobById(Long id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with ID: " + id));
        return mapToDTO(job);
    }

    // ✅ GET all jobs
    @Override
    public List<JobDto> getAllJobs() {
        return jobRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ✅ UPDATE job (by ID)
    @Override
    public JobDto updateJob(Long id, JobDto dto) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with ID: " + id));

        job.setTitle(dto.getTitle());
        job.setDescription(dto.getDescription());
        job.setLocation(dto.getLocation());
        job.setCompanyName(dto.getCompanyName());

        Job updated = jobRepository.save(job);
        return mapToDTO(updated);
    }

    // ✅ DELETE job (by ID)
    @Override
    public void deleteJob(Long id) {
        if (!jobRepository.existsById(id)) {
            throw new RuntimeException("Job not found with ID: " + id);
        }
        jobRepository.deleteById(id);
    }

    // ✅ Utility: Job → JobDto
    private JobDto mapToDTO(Job job) {
        return new JobDto(
                job.getId(),
                job.getTitle(),
                job.getDescription(),
                job.getLocation(),
                job.getCompanyName(),
                job.getRecruiter().getId()
        );
    }
}

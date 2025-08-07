package com.JobNest.services;


	import java.util.List;
	import java.util.stream.Collectors;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.JobNest.Entity.Application;
	import com.JobNest.Entity.Job;
	import com.JobNest.Entity.User;
	import com.JobNest.dto.ApplicationDto;
	import com.JobNest.repository.ApplicationRepository;
	import com.JobNest.repository.JobRepository;
	import com.JobNest.repository.UserRepository;

	@Service
	public class ApplicationServiceImpl implements ApplicationService {

	    @Autowired
	    private ApplicationRepository applicationRepository;

	    @Autowired
	    private JobRepository jobRepository;

	    @Autowired
	    private UserRepository userRepository;

	    @Override
	    public ApplicationDto apply(ApplicationDto dto) {
	        // Fetch Job and User entities from IDs
	        Job job = jobRepository.findById(dto.getJobId())
	                .orElseThrow(() -> new RuntimeException("Job not found with ID: " + dto.getJobId()));
	        User user = userRepository.findById(dto.getUserId())
	                .orElseThrow(() -> new RuntimeException("User not found with ID: " + dto.getUserId()));

	        // Create and save Application entity
	        Application application = new Application();
	        application.setJob(job);
	        application.setUser(user);
	        application.setResume(dto.getResume());

	        return mapToDTO(applicationRepository.save(application));
	    }

	    @Override
	    public List<ApplicationDto> getAllApplications() {
	        return applicationRepository.findAll()
	                .stream()
	                .map(this::mapToDTO)
	                .collect(Collectors.toList());
	    }

	    @Override
	    public List<ApplicationDto> getApplicationsByJobId(Long jobId) {
	        Job job = jobRepository.findById(jobId)
	                .orElseThrow(() -> new RuntimeException("Job not found with ID: " + jobId));
	        return applicationRepository.findByJob(job)
	                .stream()
	                .map(this::mapToDTO)
	                .collect(Collectors.toList());
	    }

	    @Override
	    public List<ApplicationDto> getApplicationsByUserId(Long userId) {
	        User user = userRepository.findById(userId)
	                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
	        return applicationRepository.findByUser(user)
	                .stream()
	                .map(this::mapToDTO)
	                .collect(Collectors.toList());
	    }

	    @Override
	    public void deleteApplication(Long id) {
	        applicationRepository.deleteById(id);
	    }

	    // Convert Entity to DTO using setters
	    private ApplicationDto mapToDTO(Application application) {
	        ApplicationDto dto = new ApplicationDto();
	        dto.setId(application.getId());
	        dto.setJobId(application.getJob().getId());
	        dto.setUserId(application.getUser().getId());
	        dto.setResume(application.getResume());
	        return dto;
	    }
	}


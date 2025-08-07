package com.JobNest.services;

import java.util.List;

import com.JobNest.dto.ApplicationDto;

public interface ApplicationService {
	    ApplicationDto apply(ApplicationDto applicationDTO);
	    List<ApplicationDto> getAllApplications();
	    List<ApplicationDto> getApplicationsByJobId(Long jobId);
	    List<ApplicationDto> getApplicationsByUserId(Long userId);
	    void deleteApplication(Long id);

	}


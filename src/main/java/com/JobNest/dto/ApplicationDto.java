package com.JobNest.dto;
import lombok.*;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class ApplicationDto {
	    private Long id;
	    private Long jobId;
	    private Long userId;
	    private String resume;
	    private String status;
	}




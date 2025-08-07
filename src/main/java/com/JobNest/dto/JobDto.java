package com.JobNest.dto;
import lombok.*;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class JobDto {
	    private Long id;
	    private String title;
	    private String description;
	    private String location;
	    private String companyName; // Match with entity
	    private Long recruiterId;
	}





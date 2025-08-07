package com.JobNest.dto;


	import lombok.*;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class RecruiterDto {
	    private Long id;
	    private String fullName;       // Changed from 'name' to match 'User' entity field
	    private String companyName;
	    private String email;
	}



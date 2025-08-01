package com.JobNest.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
public class Job {

	
	@Entity
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class Application {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String resumeLink; // or filePath
	    private String status;     // e.g. "APPLIED", "REVIEWED", "SELECTED", etc.
	    private LocalDate appliedDate;

	    @ManyToOne
	    @JoinColumn(name = "job_id")
	    private Job job;

	    @ManyToOne
	    @JoinColumn(name = "candidate_id")
	    private User candidate; // CANDIDATE only
	}

}

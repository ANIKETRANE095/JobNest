package com.JobNest.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

public class Application {
	
	@Entity
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class Job {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;
	    private String description;
	    private String location;
	    private double salary;

	    private LocalDate postedDate;

	    @ManyToOne
	    @JoinColumn(name = "recruiter_id")
	    private User recruiter;  
	}

}

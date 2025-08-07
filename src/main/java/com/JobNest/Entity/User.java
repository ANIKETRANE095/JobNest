package com.JobNest.Entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.*;
import lombok.*;

	@Entity
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class User {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String fullName;

	    @Column(unique = true, nullable = false)
	    private String email;

	    @Column(nullable = false)
	    private String password;

	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private Role role; // CANDIDATE or RECRUITER
	}


package com.JobNest.Entity;

import jakarta.persistence.*;
import lombok.*;

	@Entity
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Setter
	
	public class User {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String fullName;

	    @Column(unique = true)
	    private String email;

	    private String password;

	   
	    @Enumerated(EnumType.STRING)
	   private Role role;
		   
	    
	}



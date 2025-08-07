package com.JobNest.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Reference to the user who applied (must be a CANDIDATE)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Reference to the job being applied to
    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    // Resume as text or a URL
    @Column(nullable = false)
    private String resume;

    // Timestamp when the application was submitted
    private LocalDateTime appliedAt;
    @Column(nullable = false)
    private String status = "APPLIED"; // Default value

}

package com.JobNest.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.JobNest.dto.ApplicationDto;
import com.JobNest.services.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // ✅ Apply to a job
    @PostMapping
    public ResponseEntity<ApplicationDto> apply(@RequestBody ApplicationDto applicationDTO) {
        return ResponseEntity.ok(applicationService.apply(applicationDTO));
    }

    // ✅ Get application by its ID
    @GetMapping("/{id}")
    public ResponseEntity<List<ApplicationDto>> getApplicationById(@PathVariable Long id) {
        return ResponseEntity.ok(applicationService.getApplicationsByJobId(id));
    }

    // ✅ Get all applications (admin only)
    @GetMapping
    public ResponseEntity<List<ApplicationDto>> getAllApplications() {
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    // ✅ Delete application by ID (only by candidate who applied)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.ok("Application deleted successfully");
    }

    // ✅ Get all applications for a specific job (recruiter)
    @GetMapping("/by-job/{jobId}")
    public ResponseEntity<List<ApplicationDto>> getApplicationsByJob(@PathVariable Long jobId) {
        return ResponseEntity.ok(applicationService.getApplicationsByJobId(jobId));
    }

    // ✅ Get all applications submitted by a specific user (candidate)
    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<ApplicationDto>> getApplicationsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(applicationService.getApplicationsByUserId(userId));
    }
}


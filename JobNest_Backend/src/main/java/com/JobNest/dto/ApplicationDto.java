package com.JobNest.dto;



import lombok.Data;
import java.time.LocalDate;

@Data
public class ApplicationDto {
    private Long id;
    private String resumeLink;
    private String status;
    private LocalDate appliedDate;
    private Long jobId;
    private Long candidateId;
}

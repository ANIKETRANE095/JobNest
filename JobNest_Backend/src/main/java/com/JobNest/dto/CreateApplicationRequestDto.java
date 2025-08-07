package com.JobNest.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateApplicationRequestDto {
    @NotNull
    private Long jobId;

    @NotNull
    private Long candidateId;

    private String resumeLink; 
}

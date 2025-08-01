package com.JobNest.dto;


import lombok.Data;
import java.time.LocalDate;

@Data
public class JobDto {
    private Long id;
    private String title;
    private String description;
    private String location;
    private double salary;
    private LocalDate postedDate;
    private Long recruiterId;
}

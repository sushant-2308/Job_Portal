package com.geekster.JobSearchPortal.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "job_portal")
public class JobPortal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "employee_name")
    private String employeeName;
    private enum jobType{It, HR, Sales, Marketing,SoftwareDevelopement};

    @Column(name = "applied_date")
    private LocalDate appliedDate;
}

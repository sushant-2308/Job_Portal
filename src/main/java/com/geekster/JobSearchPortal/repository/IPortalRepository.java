package com.geekster.JobSearchPortal.repository;

import com.geekster.JobSearchPortal.model.JobPortal;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPortalRepository extends CrudRepository<JobPortal,Integer> {

    public List<JobPortal> findByTitle(String title);
    public List<JobPortal> findByDescription(String description);
    public List<JobPortal> findByLocation(String location);
    public List<JobPortal> findByCompanyName(String companyName);
    public List<JobPortal> findByTitleAndDescription(String title, String description);

    @Modifying
    @Transactional
    @Query(value = "UPDATE job_portal SET TITLE =:title WHERE LOCATION =:location", countQuery = "select count(*) from job_portal", nativeQuery = true)
    public void updateTitleByLocation(String title, String location);


    @Modifying
    @Transactional
    @Query(value = "DELETE from job_portal where EMPLOYEE_NAME=:employeeName", countQuery = "select count(*) from job_portal", nativeQuery = true)
    public void deleteByEmployeeName(String employeeName);

    @Modifying
    @Transactional
    @Query(value = "select * from job_portal where TITLE like %:title% and DESCRIPTION like %:description%", countQuery = "select count(*) from job_portal", nativeQuery = true)
    public List<JobPortal> likeTitleAndDescription(String title, String description);

}

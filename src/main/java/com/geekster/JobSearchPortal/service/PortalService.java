package com.geekster.JobSearchPortal.service;

import com.geekster.JobSearchPortal.model.JobPortal;
import com.geekster.JobSearchPortal.repository.IPortalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortalService {

    @Autowired
    IPortalRepository portalRepository;


    public Iterable<JobPortal> getAllSavedJobs()
    {
        Iterable<JobPortal> allJobs=portalRepository.findAll();
        return allJobs;
    }

    public List<JobPortal> getJobsBasedOnTitle(String title)
    {
        Iterable<JobPortal> getJobs=portalRepository.findByTitle(title);
        return (List<JobPortal>) getJobs;
    }

    public List<JobPortal> getJobsBasedOnDescription(String description)
    {
        Iterable<JobPortal> getJobs=portalRepository.findByDescription(description);
        return (List<JobPortal>) getJobs;
    }

    public List<JobPortal> getJobsBasedOnLocation(String location)
    {
        Iterable<JobPortal> getJobs=portalRepository.findByLocation(location);
        return (List<JobPortal>) getJobs;
    }

    public List<JobPortal> getJobsBasedOnCompanyName(String companyName)
    {
        Iterable<JobPortal> getJobs=portalRepository.findByCompanyName(companyName);
        return (List<JobPortal>) getJobs;
    }

    public String addNewJobs(JobPortal jobPortalList)
    {
        JobPortal addJobs=portalRepository.save(jobPortalList);
        if(addJobs!=null)
            return "Jobs successfully added...!!!";
        else
            return "Failed to save Jobs";
    }

    public List<JobPortal> getJobsBasedOnTitleAndDescription(String title, String description)
    {
        return portalRepository.findByTitleAndDescription(title,description);

    }

    public void updateTitleBasedOnLocation(String title, String location)
    {
        portalRepository.updateTitleByLocation(title,location);
    }

    public void deleteJobEmployee(String employeeName)
    {
        portalRepository.deleteByEmployeeName(employeeName);
    }

    public List<JobPortal> getTitleDescriptionLike(String title, String description)
    {
        return portalRepository.likeTitleAndDescription(title,description);
    }
}

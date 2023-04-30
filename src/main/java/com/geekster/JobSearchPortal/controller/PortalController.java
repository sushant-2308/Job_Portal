package com.geekster.JobSearchPortal.controller;


import com.geekster.JobSearchPortal.model.JobPortal;
import com.geekster.JobSearchPortal.service.PortalService;
import com.geekster.JobSearchPortal.util.PortalUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PortalController {

    @Autowired
    PortalService portalService;

    @GetMapping(value = "/getAllJobs")
    public Iterable<JobPortal> getJobs()
    {
        return portalService.getAllSavedJobs();
    }

    @GetMapping(value = "/getTitle/{title}")
    public List<JobPortal> getJobsByTitle(@PathVariable String title)
    {
        return portalService.getJobsBasedOnTitle(title);
    }

    @GetMapping(value = "/getDesc/{description}")
    public List<JobPortal> getJobsByDescription(@PathVariable String description)
    {
        return portalService.getJobsBasedOnDescription(description);
    }

    @GetMapping(value = "/getLocation/{location}")
    public List<JobPortal> getJobsByLocation(@PathVariable String location)
    {
        return portalService.getJobsBasedOnLocation(location);
    }

    @GetMapping(value = "/getCompany/{companyName}")
    public List<JobPortal> getJobsBycompanyName(@PathVariable String companyName)
    {
        return portalService.getJobsBasedOnCompanyName(companyName);
    }

    @GetMapping(value = "/title/description")
    public List<JobPortal> getJobsByTitleAndDescription(@RequestParam(value = "title", required = true) String title, @RequestParam(value = "description", required = true) String description)
    {
        return portalService.getJobsBasedOnTitleAndDescription(title,description);
    }

    @GetMapping(value = "/likeTitleAndDescription")
    public List<JobPortal> getJobLikeTitleAndDescription(@RequestParam(value = "title", required = true) String title, @RequestParam(value = "description", required = true) String description)
    {
       return portalService.getTitleDescriptionLike(title,description);
    }

    @PostMapping(value = "/addJobs")
    public String addJobs(@RequestBody JobPortal jobPortalList)
    {
        JSONObject json=new JSONObject(jobPortalList);
        List<String> validationList = PortalUtil.userValidation(json);
        if (validationList.isEmpty()) {
            JobPortal job = PortalUtil.setUser(json);
            portalService.addNewJobs(job);
            return "User Saved Successfully";
        } else {
            return validationList.toString();
        }
    }

    @PutMapping(value = "/updateTitle")
    public void updateTitleByLocation(@RequestParam(value = "title", required = true) String title, @RequestParam(value = "location", required = true) String location)
    {
        portalService.updateTitleBasedOnLocation(title,location);
    }

    @DeleteMapping(value = "/deleteEmployee")
    public void deleteJobByEmployee(@RequestParam(value = "employeeName", required = true) String employeeName)
    {
        portalService.deleteJobEmployee(employeeName);
    }
}

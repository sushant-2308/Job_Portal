package com.geekster.JobSearchPortal.util;

import com.geekster.JobSearchPortal.model.JobPortal;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PortalUtil {

    public static List<String> userValidation(JSONObject json) {
        List<String> errors = new ArrayList<>();

        if (json.getString("title").length() == 0) {
            errors.add("TITLE:- TITLE is Mandatory");
        }
        if (json.getString("description").length() == 0) {
            errors.add("DESCRIPTION:- DESCRIPTION is Mandatory");
        }
        if (json.getString("location").length() == 0) {
            errors.add("LOCATION:- LOCATION is Mandatory");
        }
        if (json.getString("companyName").length() == 0) {
            errors.add("COMPANYNAME:- COMPANYNAME is Mandatory");
        }
        return errors;
    }

    public static JobPortal setUser(JSONObject json) {
        JobPortal jobs = new JobPortal();
        jobs.setTitle(json.getString("title"));
        jobs.setDescription(json.getString("description"));
        jobs.setLocation(json.getString("location"));
        jobs.setSalary(json.getDouble("salary"));
        jobs.setCompanyName(json.getString("companyName"));
        jobs.setEmployeeName(json.getString("employeeName"));
        LocalDate currDate = LocalDate.now();
        jobs.setAppliedDate(currDate);
        return jobs;
    }
}

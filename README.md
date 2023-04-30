# JobPortal Query Project

## Frameworks and Language used:
 - Spring
 - Spring boot
 - My-Sql
 - Java

 ## Data Flow
 #### Controller
 - getJobs
 - getJobsByTitle
 - getJobsByDescription
 - getJobsByLocation
 - getJobsBycompanyName
 - getJobsByTitleAndDescription
 - getJobLikeTitleAndDescription
 - addJobs
 - updateTitleByLocation
 - deleteJobByEmployee

 #### Service
 - getAllSavedJobs
 - getJobsBasedOnTitle
 - getJobsBasedOnDescription
 - getJobsBasedOnLocation
 - getJobsBasedOnCompanyName
 - addNewJobs
 - getJobsBasedOnTitleAndDescription
 - updateTitleBasedOnLocation
 - deleteJobEmployee
 #### Repository
 - findByTitle
 - findByDescription
 - findByLocation
 - findByCompanyName
 - findByTitleAndDescription
 - updateTitleByLocation
 - deleteByEmployeeName
 - likeTitleAndDescription
 #### Model
 - id
 - title
 - description
 - location
 - salary
 - companyName
 - employeeName
 - jobType
 - appliedDate
 #### Util
 - userValidation
 - setUser
### Project Summary
Created a Simple job portal project in which I have created a model of job details and description and added some of the custom queries. Using that custom queries I have used many of the get mapping method to fetch my data in different ways like by firstName lastName age etc.

### How to use in your system?
 - Just Simply clone this reposit
 - Start your server
 - Perform operations 

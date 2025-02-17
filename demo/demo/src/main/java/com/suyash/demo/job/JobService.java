package com.suyash.demo.job;

//WE WILL CREATE AN INTERFACE FOR LOES COUPLING

import java.util.List;

public interface JobService
{
    List<Job> findAll();
   void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updatedJob(Long id, Job updatedJob);
}

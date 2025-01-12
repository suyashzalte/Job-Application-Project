package com.suyash.demo.impl;

//WE WILL DEFINE METHODS

import com.suyash.demo.job.Job;
import com.suyash.demo.job.JobRepository;
import com.suyash.demo.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service

public class JobServiceImpl implements JobService {
    //WHEN WE IMPLEMENT ANY CLASS IN THE CLASS THEN WE HAVE TO IMPLEMENT ALL ITS DEFINE METHODE INTO iIMPLEMENTED CLASS


    //private List<Job> jobs= new ArrayList<>();
    // WILLING POSTING THE ID, IT YOU MISTAKENLY NOT PUT THE VALUE FOR ID IT IS TAKEING IT AS 0 OR NULL
    //SO WE WILL TAKE VALUE WHICH WILL BE 1 : " private Long nextId=1L;"
    JobRepository jobRepository;


    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll()
    {

        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job)
    {
        //INCREMENT THE VALUE

        jobRepository.save(job);

    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);

    }
    // EXPLANATION 1:23:00
    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updatedJob(Long id, Job updatedJob) {
        Optional<Job>jobOptional= jobRepository.findById((id));
        if ((jobOptional.isPresent()))
        {
            Job job=jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}

package com.suyash.demo.job;
//IN THESE CLASS WE ARE HANDLING THE LOGIC OF ADDING JOB INTO OUR CONTROLLER

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/jobs")

public class JobController
{
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    private JobService jobService;
    //we will create an end point through which we will return all the JOB
    //create a list and input the data from Job.class

    @GetMapping// WHEN THESE URL GET HITS "/jobs" THESE METHODE WILL GET EXECUTE AND ALL JOB LIST WILL BE HIT WHICH ARE UPDATED IN APPLICATION

    public ResponseEntity<List<Job>> findAll()
    {

        return ResponseEntity.ok(jobService.findAll());//WE HAVE TO CREATE ITS OBJECT
    }
    //CREATE AN POST REQUEST HANDLER WHICH WILL HANDEL ALL THE POST REQUEST OR IT WILL ADD THE JOB AND WILL RETURN THE SUCCESSFULLY MESSAGE
    @PostMapping
    public  ResponseEntity<String> createJob(@RequestBody Job job)//here we have assign the parameter for job
    {
        jobService.createJob(job);// we had created parameter for job in these methode

        return new ResponseEntity<>( "job successfully added", HttpStatus.CREATED);//ResponseEntity<> MAINTAIN A PROJECT MODULARITY CONSISTENCY AND SIMPLE TO USE AND READ
                                                                                         //HttpStatus.CREATED which indicates that a request has been successfully fulfilled and has resulted in the creation of a new resource.
    }
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id)
    {
      //HERE WE HAVE CREATED THE JOB OBJECT
        Job job = jobService.getJobById(id);
        if (job !=null)
            return new ResponseEntity<>(job, HttpStatus.OK);

            //HERE WE WILL RETURN THE RESPOSNSE
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }
    //   1:17:00 LLogic part explain, Check and deploy it
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteJo(@PathVariable Long id)
    {
        boolean deleted = jobService.deleteJobById(id);
        if (deleted)
            return new ResponseEntity<>("Job deleted Successfully", HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //1:28:00 Logic Explanation
    @PutMapping("/{id}")
   // @RequestMapping(value ="/Jobs/{id}",method = RequestMethod.PUT)

    public  ResponseEntity<String> update(@PathVariable Long id,@RequestBody Job updatedJob)
    {
        boolean updated =jobService.updatedJob(id, updatedJob);
        if (updated)
            return new ResponseEntity<>("Job Updated SuccessFully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }



}

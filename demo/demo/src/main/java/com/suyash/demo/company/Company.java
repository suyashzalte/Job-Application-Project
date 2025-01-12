package com.suyash.demo.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.suyash.demo.job.Job;
import com.suyash.demo.review.Review;
import jakarta.persistence.*;

import java.util.List;
@Entity

public class Company
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//for auto generating id
    private Long id;
    private String name ;
    private String description;

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }


    @JsonIgnore
    @OneToMany(mappedBy = "company")// MEANS THAT ONE COMPANY HAS MANY JOBS
    private List<Job> jobs;



    @OneToMany(mappedBy = "company")
    private List<Review>reviews;

    //NOW WE WILL GENERATE DEFAULT CONSTRUCTOR FOR CLASS Company;

    public Company()
    {
        //DEFAULT CONSTRUCTOR
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

//NOW WE WILL GENERATE GETTER AND SETTER FOR ALL THE PARAMETERS

    //GETTER AND SETTER FOR ID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    //getter and setter for name

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this. name =name ;
    }

    //getter and setter for description;

    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description= description;
    }

}

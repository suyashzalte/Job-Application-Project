package com.suyash.demo.job;


import org.springframework.data.jpa.repository.JpaRepository;

//REPOSITORY IS AN INTERFACE THAT ALLOW US TO PERFORM VARIOUS INFORMATION THAT CAN PERFORM CURD OPERATION LIKE CREATE, READ, UPDATE, DELETE WITHOUT WRITING BOILER PLATE CODE
public interface JobRepository extends JpaRepository<Job, Long>
{


}

package com.suyash.demo.job;


import com.suyash.demo.company.Company;
import jakarta.persistence.*;

@Entity
//@Table(name ="job_table")
public class  Job
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title ;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @ManyToOne
    private Company company;

    //GENERATOR PARAMETRIZE CONSTRUCTOR

    public Job(long id, String title, String description, String minSalary, String maxSalary, String location )
    {
        this.id=id;
        this.description=description;
        this.title=title;
        this.minSalary=minSalary;
        this.maxSalary=maxSalary;
        this.location=location;

    }
   //GENERATE DEFAULT CONSTRUCTOR
    public Job()
    {
        //DEFAULT NO ARGUMENT CONSTRUCTOR
    }
    //  NOW GENERATE GETTER AND SETTER FOR ALL ;
    //GETTER ALWAYS HAVE PARAMETER RETURN TYPE EG: INT, FLOAT, DOUBLE
    //SETTER ALWAYS HAVE VOID AS THERE RETURN TYPE.
    public Long getId()
    {
        return id;
    }
    public void setId(long id )
    {
        this.id=id;
    }




    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title=title;
    }


    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description=description;
    }



    public String getMinSalary()
    {
        return minSalary;
    }
    public void setMinSalary(String minSalary)
    {
        this.minSalary=minSalary;
    }



    public String getMaxSalary()
    {
        return maxSalary;
    }
    public void setMaxSalary(String maxSalary)
    {
        this.maxSalary=maxSalary;
    }


    public String getLocation()
    {
        return location;
    }
    public void setLocation(String location)
    {
        this.location=location;
    }
}


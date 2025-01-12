package com.suyash.demo.company.impl;

import com.suyash.demo.company.Company;
import com.suyash.demo.company.CompanyRepository;
import com.suyash.demo.company.CompanyService;
import com.suyash.demo.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService
{
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional= companyRepository.findById((id));
        if ((companyOptional.isPresent()))
        {
            Company companyToUpdate= companyOptional.get();
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setName(company.getName());
            companyToUpdate.setJobs(company.getJobs());
            companyRepository.save(companyToUpdate);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void createCompany(Company company) {
        // HERE WE WILL WRITE THE CODE TO CREATE A COMPANY
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if( companyRepository.existsById(id))
        {
            companyRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

}

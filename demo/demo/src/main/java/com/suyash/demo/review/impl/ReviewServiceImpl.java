package com.suyash.demo.review.impl;

import com.suyash.demo.company.Company;
import com.suyash.demo.company.CompanyService;
import com.suyash.demo.review.Review;
import com.suyash.demo.review.ReviewRepository;
import com.suyash.demo.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository , CompanyService companyService ) {
        this.reviewRepository = reviewRepository;
        this.companyService=companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId)
    {
        List<Review> reviews=reviewRepository.findByCompanyId(companyId) ;
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review)
    {
        Company company=companyService.getCompanyById(companyId);
        if (company!=null)
        {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;

        }
        else {
            return false;
        }

    }

    @Override
    public Review getReview(Long companyId, Long reviewId)
    {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

        return reviews.stream().filter(review ->review.getId().equals(reviewId)).findFirst().orElse(null);//EXPLANATION : #3 1:31:00
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview)
    {
        if (companyService.getCompanyById(companyId)!= null)
        {
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;


        }
        else {
            return false;
        }

    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if (companyService.getCompanyById(companyId)!= null
                && reviewRepository.existsById(reviewId))
        {
            Review review=reviewRepository.findById(reviewId).orElse(null);//   RETRIEVING THE REVIEW
            Company company=review.getCompany();//RETRIEVING THE COMPANY
            company.getReviews().remove(review);//REMOVING THE REVIEW FROM THE COMPANY REFERENCE
            review.setCompany(null);
            companyService.updateCompany(company,companyId);//UPDATING THE COMPANY
            reviewRepository.deleteById(reviewId);//FINALLY DELETING THE REVIEW
            return true;
        }
        else {
            return false;
        }

    }
}

//EXPLANATION: 16:00
//WHAT IS SPRING BOOT ACTUATOR  : IT PROVIDE THE BUILTIN PRODUCTION READY FEATURE WHICH MANAGES YOUR APPLICATION
// IT ALSO GIVES THE ABILITY TO MONITOR OR PEAK IN THE APPLICATION TO MANAGE THE APPLICATION
//ACTUATOR FEATURE : 1. IT HAS TONS OF BUILTIN  END POINTS, 2. IT PROVIDES ABILITY OR DASHBOARD TO VIEW REAL  TIME METRICS, 3.CUSTOMIZABLE, HANDLE ACTUATOR MORE FLUENTLY AND MANAGE IT
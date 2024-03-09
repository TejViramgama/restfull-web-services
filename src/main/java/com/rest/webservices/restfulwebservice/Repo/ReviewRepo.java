package com.rest.webservices.restfulwebservice.Repo;

import com.rest.webservices.restfulwebservice.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review,Integer> {
}

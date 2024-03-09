package com.rest.webservices.restfulwebservice.Repo;

import com.rest.webservices.restfulwebservice.Model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepo extends JpaRepository<Meal,Integer> {
}

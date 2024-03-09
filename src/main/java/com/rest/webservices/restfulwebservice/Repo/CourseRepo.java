package com.rest.webservices.restfulwebservice.Repo;

import com.rest.webservices.restfulwebservice.Model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "cr")
public interface CourseRepo extends JpaRepository<Course, Integer> {


    Page<Course> findAllByOrderByIdDesc(PageRequest pageRequest);
}

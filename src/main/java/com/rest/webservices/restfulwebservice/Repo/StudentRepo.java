package com.rest.webservices.restfulwebservice.Repo;

import com.rest.webservices.restfulwebservice.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
}

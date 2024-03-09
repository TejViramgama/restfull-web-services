package com.rest.webservices.restfulwebservice.Repo;

import com.rest.webservices.restfulwebservice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}

package com.rest.webservices.restfulwebservice.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "review_rd")
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Integer rating;

    private String review;

    @JsonBackReference
    @ManyToOne()
    private Course course;
}

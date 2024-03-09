package com.rest.webservices.restfulwebservice.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "meetup")
@Getter
@Setter
public class Meetup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;
    private String image;
    private String address;
    private String description;
}

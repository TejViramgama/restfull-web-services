package com.rest.webservices.restfulwebservice.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course_rd")
@Getter
@Setter
@SQLDelete(sql = "update rest_demo.course_rd set is_deleted=true where id=?")
@Where( clause = "is_deleted = false")
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonManagedReference
    private Creator creator;

    @JsonManagedReference
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    private boolean isDeleted;

    public void addReview(Review review){
        this.reviews.add(review);
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void removeReview(Review review){
        this.reviews.remove(review);
    }
}

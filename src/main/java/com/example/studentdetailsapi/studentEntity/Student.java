package com.example.studentdetailsapi.studentEntity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.repository.cdi.Eager;

@Getter
@Entity
@Builder
@Data
@Table(name = "student")
public class Student {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    long Id;

    @Column(name="firstname")
    String firstName;



    @Column(name="lastname")
    String lastName;
    public Student(){

    }
    public Student(long id, String firstName, String lastName) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Student( String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }
}

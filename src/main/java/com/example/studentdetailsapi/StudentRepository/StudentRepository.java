package com.example.studentdetailsapi.StudentRepository;

import com.example.studentdetailsapi.studentEntity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query(value = "SELECT [Id],[firstName],[lastName] FROM [student].[dbo].[student] where Id>10;",nativeQuery = true)
    public List<Student> getIdGreaterThanTenRepository();
}

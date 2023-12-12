package com.example.studentdetailsapi.controller;

import com.example.studentdetailsapi.services.StudentService;
import com.example.studentdetailsapi.studentEntity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping(value = "/student")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudent(){
        return studentService.getStudents().stream().toList();

    }
    @GetMapping(value = "student/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Student> getStudentById(@PathVariable long id){
        return studentService.getStudentsByIdService(id);
    }
    @DeleteMapping(value = "student/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(@PathVariable long id){
        studentService.deleteStudentByIdService(id);
    }
    @PutMapping(value = "student/put/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudentById(@PathVariable long id, @RequestBody Student student){
        Student current=studentService.updateStudentByIdService(id);
        current.setId(student.getId());
        current.setFirstName(student.getFirstName());
        current.setLastName(student.getLastName());
        studentService.saveService(current);
        return current;


    }
    @PostMapping(value = "student/post")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public HttpStatus createStudent(@RequestBody Student student){
        long newId= student.getId();
        String newFirstName=student.getFirstName();
        String newLastName=student.getLastName();
        Student newStudent=new Student(newId,newFirstName,newLastName);
        studentService.saveService(newStudent);
        return HttpStatus.ACCEPTED;
    }
    @GetMapping(value = "/student/idGreaterThanTen")
    public List<Student> idGreaterThanTen(){
        return studentService.idGreaterThanTenService();
    }




}

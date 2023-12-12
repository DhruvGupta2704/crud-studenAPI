package com.example.studentdetailsapi.services;

import com.example.studentdetailsapi.StudentRepository.StudentRepository;
import com.example.studentdetailsapi.studentEntity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentsByIdService(long id) {
        return studentRepository.findById(id);
    }

    public void deleteStudentByIdService(long id) {
        studentRepository.deleteById(id);
    }
    public Student updateStudentByIdService(long id){
        return studentRepository.findById(id).get();
    }

    public void saveService(Student student) {
        studentRepository.save(student);
    }

    public List<Student> idGreaterThanTenService() {
        return studentRepository.getIdGreaterThanTenRepository();
    }
}

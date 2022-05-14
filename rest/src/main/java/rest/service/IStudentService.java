package rest.service;

import rest.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> findAll();

    Student  save(Student student);

    Student findById(Integer integer);

    String deleteById(Integer integer);

    Student updateStudent(Student student);
}

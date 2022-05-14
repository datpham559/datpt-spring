package rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.entity.Student;
import rest.repository.StudentRepository;
import rest.service.IStudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository repo;

    @Override
    public List<Student> findAll() {
        return repo.findAll();
    }

    @Override
    public  Student  save(Student student) {
        return repo.save(student);
    }

    @Override
    public Student findById(Integer id) {

        return repo.findById(id).get();
    }

    @Override
    public String deleteById(Integer id) {
        repo.deleteById(id);
        return "student removed " + id;
    }
    public Student updateStudent(Student student){
        Student s = repo.findById(student.getId()).get();
        s.setName(student.getName());
        s.setAge(student.getAge());

        return repo.save(s);
    }

}

package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.entity.Student;
import rest.service.IStudentService;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private IStudentService service;

    @PostMapping(value = "/student/create")
    public Student createStudent(@RequestBody Student student){
        return service.save(student);
    }
    @GetMapping(value = "/student")
    public List<Student> getStudent(){
        return service.findAll();
    }
    @DeleteMapping(value = "/student/delete/{id}")
    public String deleteStudent(@PathVariable Integer id){
        return service.deleteById(id);
    }

    @PutMapping(value = "/student/update")
    public Student updateStudent(@RequestBody Student student){

        return service.updateStudent(student);
    }

    @GetMapping(value="/student/{id}")
    public Student findStudentbyId(@PathVariable Integer id)
    {
        return service.findById(id);
    }
}

package rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.dto.PTUserDTO;
import rest.entity.PTUser;
import rest.service.PTUserService;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

import static rest.controller.GlobalExceptionHandler.handleConstraintViolationException;

@RestController
@RequestMapping(value = "/api")
public class PTUserController {
    private final PTUserService ptUserService;
    public PTUserController(PTUserService ptUserService) {
        this.ptUserService = ptUserService;
    }

    @PostMapping(value = "/ptuser")
    public ResponseEntity<?> createStudent(@RequestBody PTUserDTO ptUserDTO) {
        try {
            PTUser result = ptUserService.save(ptUserDTO);
            return ResponseEntity.ok().body(result);
        } catch (ConstraintViolationException ex) {
            String message = handleConstraintViolationException(ex);
            return ResponseEntity.badRequest().body(message);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @GetMapping(value = "/student")
    public List<PTUser> getStudent() {
        return ptUserService.findAll();
    }

    @DeleteMapping(value = "/student/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        return null;
    }

    @PutMapping(value = "/student/update")
    public PTUser updateStudent(@RequestBody PTUser PTUser) {

        return ptUserService.updateStudent(PTUser);
    }

    @GetMapping(value = "/student/{id}")
    public PTUser findStudentbyId(@PathVariable Integer id) {
        return null;
    }
}

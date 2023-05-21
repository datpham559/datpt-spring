package rest.service;

import rest.dto.PTUserDTO;
import rest.entity.PTUser;

import java.util.List;

public interface PTUserService {
    List<PTUser> findAll();

    PTUser save(PTUserDTO ptUserDTO);

    PTUser findById(Long integer);

    String deleteById(Long integer);

    PTUser updateStudent(PTUser PTUser);
}

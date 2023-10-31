package rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import rest.dto.PTUserDTO;
import rest.entity.PTUser;
import rest.repository.PTUserRepository;
import rest.service.PTUserService;
import rest.utils.Ultils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Service
public class PTUserServiceImpl implements PTUserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final PTUserRepository ptUserRepository;

    public PTUserServiceImpl(PTUserRepository ptUserRepository) {
        this.ptUserRepository = ptUserRepository;
    }


    @Override
    public List<PTUser> findAll() {
        return ptUserRepository.findAll();
    }

    @Override
    public PTUser save(@Valid PTUserDTO ptUserDTO) {
        PTUser ptUser = convertToEntity(ptUserDTO);
        return ptUserRepository.save(ptUser);
    }

    private PTUser convertToEntity(PTUserDTO ptUserDTO) {
        PTUser ptUser = new PTUser();
        ptUser.setAddress(ptUserDTO.getAddress());
        ptUser.setEmail(ptUserDTO.getEmail());
        ptUser.setDateofbirth(Ultils.convertStringToLocalDateTime(ptUserDTO.getDateofbirth()));
        ptUser.setFullname(ptUserDTO.getFullname());
        ptUser.setPassword(passwordEncoder.encode(ptUserDTO.getPassword()));
        ptUser.setIdentifycation(ptUserDTO.getIdentifycation());
        ptUser.setPhonenumber(ptUserDTO.getPhonenumber());
        ptUser.setUsername(ptUserDTO.getUsername());
        return ptUser;
    }

    @Override
    public PTUser findById(Long id) {
        PTUser ptUser = ptUserRepository.getOnePTUser(id);
        return ptUser;
    }

    @Override
    public String deleteById(Long integer) {
        return null;
    }

    @Override
    public PTUser updateStudent(PTUser PTUser) {
        return null;
    }
}

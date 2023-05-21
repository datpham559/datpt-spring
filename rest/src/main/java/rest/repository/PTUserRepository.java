package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.entity.PTUser;

@Repository
public interface PTUserRepository extends JpaRepository<PTUser,Long> {
}

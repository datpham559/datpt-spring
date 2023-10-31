package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rest.entity.PTUser;

import java.util.Optional;

@Repository
public interface PTUserRepository extends JpaRepository<PTUser,Long>,PTUserRepositoryCustom {
    @Query(value = "SELECT * from PTUser where username = ?1",nativeQuery = true)
    Optional<PTUser> findByUsername(String userName);

}

package pe.edu.upc.finanzasbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.finanzasbackend.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByPassword(String password);
    Boolean existsUserByEmail(String email);
    Boolean existsUserByUserName(String userName);
    @Query("select u from User u where u.email = :userEmail and u.password= :userPassword")
    Optional<User> findUserByEmailAndPassowrd(@Param("userEmail") String userEmail, @Param("userPassword") String userPassword);
}

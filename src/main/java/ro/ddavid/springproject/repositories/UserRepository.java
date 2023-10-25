package ro.ddavid.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.ddavid.springproject.models.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Using method naming convention
    List<User> findByLastName(String lastName);

    // Explicit JPQL
    @Query("SELECT u FROM User u WHERE u.lastName = :lastName")
    List<User> findUsersByLastNameJPQL(String lastName);

    // Native SQL
    @Query(value = "SELECT * FROM users WHERE last_name = :lastName", nativeQuery = true)
    List<User> findUsersByLastNameNative(String lastName);
}

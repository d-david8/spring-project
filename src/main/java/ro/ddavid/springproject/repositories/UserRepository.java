package ro.ddavid.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.ddavid.springproject.models.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

package bonsen.nl.puzzled.repository;

import bonsen.nl.puzzled.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
    boolean existsByEmail(String email);

}
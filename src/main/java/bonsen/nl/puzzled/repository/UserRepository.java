package bonsen.nl.puzzled.repository;

import bonsen.nl.puzzled.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
package bonsen.nl.puzzled.repository;

import bonsen.nl.puzzled.model.authority.Authority;
import bonsen.nl.puzzled.model.authority.AuthorityKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, AuthorityKey> {
}

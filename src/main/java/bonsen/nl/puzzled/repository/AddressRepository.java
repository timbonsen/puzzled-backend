package bonsen.nl.puzzled.repository;

import bonsen.nl.puzzled.model.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}

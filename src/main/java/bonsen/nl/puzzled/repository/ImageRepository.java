package bonsen.nl.puzzled.repository;

import bonsen.nl.puzzled.model.image.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
}

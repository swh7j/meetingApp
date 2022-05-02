package app.Repository;

import app.Entity.AcademyEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AcademyRepository extends JpaRepository<AcademyEntity, Long> {
}

package app.Repository;

import app.Entity.AcademyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AcademyRepository extends JpaRepository<AcademyEntity, Long> {
    @Query(value="SELECT * FROM test.academy", nativeQuery = true)
    List<AcademyEntity> findall2();
}

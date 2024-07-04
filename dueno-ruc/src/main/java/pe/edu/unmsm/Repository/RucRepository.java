package pe.edu.unmsm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.unmsm.Model.RucModel;

import java.util.Optional;

public interface RucRepository extends JpaRepository<RucModel, Long> {
    Optional<RucModel> findByRuc(String ruc);
}

package pe.edu.unmsm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.unmsm.Model.DuenoModel;

import java.util.Optional;

public interface DuenoRepository extends JpaRepository<DuenoModel, Long> {
    Optional<DuenoModel> findByNumero(String numero);
}

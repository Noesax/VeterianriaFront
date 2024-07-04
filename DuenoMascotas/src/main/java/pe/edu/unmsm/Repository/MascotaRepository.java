package pe.edu.unmsm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.unmsm.Model.Mascota;

import java.util.List;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    List<Mascota> findByUsuarioId(Long usuarioId);
}

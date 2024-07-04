package pe.edu.unmsm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.unmsm.Model.Consulta;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByMascotaId(Long mascotaId);
    List<Consulta> findByUsuarioId(Long usuarioId);
    List<Consulta> findByMascotaIdAndUsuarioId(Long mascotaId, Long usuarioId);
}

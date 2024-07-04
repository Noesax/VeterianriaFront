package pe.edu.unmsm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.unmsm.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCorreo(String correo);
}

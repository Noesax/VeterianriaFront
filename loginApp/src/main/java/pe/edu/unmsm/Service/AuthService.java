package pe.edu.unmsm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.Model.Usuario;
import pe.edu.unmsm.Repository.UsuarioRepository;

@Service
public class AuthService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean autenticar(String correo, String contraseña) {
        Usuario usuario = usuarioRepository.findByCorreo(correo);
        return usuario != null && usuario.getContrasenia().equals(contraseña);
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}

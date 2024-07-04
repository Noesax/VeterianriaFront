package pe.edu.unmsm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.unmsm.Model.Usuario;
import pe.edu.unmsm.Service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody Usuario loginForm) {
        String correo = loginForm.getCorreo();
        String contrasenia = loginForm.getContrasenia();

        if (authService.autenticar(correo, contrasenia)) {
            return "¡Login exitoso!";
        } else {
            return "¡Credenciales incorrectas!";
        }
    }

    @PostMapping("/crear")
    public Usuario crear(@RequestBody Usuario usuario) {
        return authService.crearUsuario(usuario);
    }
}

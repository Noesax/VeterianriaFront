package pe.edu.unmsm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unmsm.Model.DuenoModel;
import pe.edu.unmsm.Service.DuenoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DuenoController {
    @Autowired
    private DuenoService duenoService;

    @PostMapping("/duenos")
    public ResponseEntity<String> createDueno(@RequestBody DuenoModel duenoModel) {
        String responseMessage = duenoService.createDueno(duenoModel);
        if (responseMessage.equals("El DNI ya está registrado.")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(responseMessage);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
    }

    @GetMapping("/duenos")
    public List<DuenoModel> getAllDuenos() {
        return duenoService.getAllDuenos();
    }
}

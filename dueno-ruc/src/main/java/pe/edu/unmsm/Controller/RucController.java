package pe.edu.unmsm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unmsm.Model.RucModel;
import pe.edu.unmsm.Repository.RucRepository;
import pe.edu.unmsm.Service.RucService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RucController {
    @Autowired
    private RucRepository rucRepository;
    @Autowired
    private RucService rucService;

    /*@PostMapping("/ruc")
    public RucModel createRuc(@RequestBody RucModel rucModel) {
        return rucRepository.save(rucModel);
    }*/

    @PostMapping("/ruc")
    public ResponseEntity<?> saveRuc(@RequestBody RucModel rucModel) {
        if(rucService.findByRuc(rucModel.getRuc()).isPresent()){
            return ResponseEntity.status(409).body("Ruc ya existe");
        }
        RucModel savedRuc = rucRepository.save(rucModel);
        return ResponseEntity.ok(savedRuc);
    }

    @GetMapping("/ruc")
    public List<RucModel> getAllRuc() {
        return rucRepository.findAll();
    }
}

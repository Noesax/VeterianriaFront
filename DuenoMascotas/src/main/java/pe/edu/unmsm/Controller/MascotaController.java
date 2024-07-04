package pe.edu.unmsm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unmsm.Model.Mascota;
import pe.edu.unmsm.Service.MascotaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @PostMapping
    public ResponseEntity<Mascota> registerPet(@RequestBody Mascota pet) {
        Mascota savedPet = mascotaService.registerPet(pet);
        return ResponseEntity.ok(savedPet);
    }

    @GetMapping("/{petId}")
    public ResponseEntity<Mascota> getPetById(@PathVariable Long petId) {
        Optional<Mascota> pet = mascotaService.getPetById(petId);
        return pet.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{petId}")
    public ResponseEntity<Mascota> updatePet(@PathVariable Long petId, @RequestBody Mascota updatedPet) {
        Optional<Mascota> updatedPetOptional = mascotaService.updatePet(petId, updatedPet);
        return updatedPetOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{petId}")
    public ResponseEntity<Void> deletePet(@PathVariable Long petId) {
        boolean isDeleted = mascotaService.deletePet(petId);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/owner/{usuarioId}")
    public ResponseEntity<List<Mascota>> getPetsByOwnerId(@PathVariable Long usuarioId) {
        List<Mascota> pets = mascotaService.getPetsByOwnerId(usuarioId);
        return ResponseEntity.ok(pets);
    }
}

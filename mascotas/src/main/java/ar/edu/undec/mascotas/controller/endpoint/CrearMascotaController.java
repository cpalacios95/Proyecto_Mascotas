package ar.edu.undec.mascotas.controller.endpoint;


import ar.edu.undec.mascotas.controller.dtomodel.MascotaDTO;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.exceptions.MascotaException;
import ar.edu.undec.mascotas.input.ICrearMascotaInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrearMascotaController {

    @Autowired
    ICrearMascotaInput iCrearMascotaInput;

    @PostMapping(value = "mascotas")
    public ResponseEntity<?> crearMascota(@RequestBody MascotaDTO mascotaDTO) throws MascotaException {

        Mascota mascota = Mascota.getInstance(mascotaDTO.getNombre(), mascotaDTO.getRaza(), mascotaDTO.getFechaNac());

        iCrearMascotaInput.crearMascota(mascota);

        return ResponseEntity.status(HttpStatus.OK).body("mascota creada con exito");
    }

}

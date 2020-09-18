package ar.edu.undec.mascotas.input;

import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.exceptions.MascotaException;

public interface IModificarMascotaInput {

    boolean modificarMascota(Mascota mascota, String nuevoNombre);
}

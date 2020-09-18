package ar.edu.undec.mascotas.input;

import ar.edu.undec.mascotas.domain.Mascota;

import java.time.LocalDate;

public interface IModificarMascotaInput {

    boolean modificarNombreMascota(Mascota mascota, String nuevoNombre);
    boolean modificarRazaMascota(Mascota mascota, String nuevaRaza);
    boolean modificarFechaNacMascota(Mascota mascota, LocalDate nuevaFechaNac);


}

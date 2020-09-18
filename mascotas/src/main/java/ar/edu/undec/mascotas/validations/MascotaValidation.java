package ar.edu.undec.mascotas.validations;

import ar.edu.undec.mascotas.exceptions.MascotaException;

import java.time.LocalDate;

public class MascotaValidation {

    public static void validarDatos(String nombre, String raza, LocalDate fechaNac) throws MascotaException {

        if(nombre.length()==0) throw new MascotaException("El nombre de la mascota no puede ser vacio");

        if(raza.length()==0) throw new MascotaException("La raza de la mascota no puede ser vacio");

        if(fechaNac.isBefore(LocalDate.of(1990,1,1))) throw new MascotaException("La fecha de nacimiento de la mascota no puede ser menor a 1990");

        if(fechaNac.isAfter(LocalDate.now())) throw new MascotaException("La fecha de nacimiento de la mascota no puede ser menor a 1990");
    }

}

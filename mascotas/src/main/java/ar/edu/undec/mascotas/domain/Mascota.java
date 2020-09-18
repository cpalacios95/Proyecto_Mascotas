package ar.edu.undec.mascotas.domain;

import ar.edu.undec.mascotas.exceptions.MascotaException;
import ar.edu.undec.mascotas.validations.MascotaValidation;

import java.time.LocalDate;

public class Mascota {

    private String nombre;
    private LocalDate fechaNac;
    private String raza;

    public Mascota(String nombre, String raza, LocalDate fechaNac) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.raza=raza;
    }

    public static Mascota getInstance(String nombre, String raza, LocalDate fechaNac) throws MascotaException {
        MascotaValidation.validarDatos(nombre,raza,fechaNac);

        return new Mascota(nombre,raza,fechaNac);
    }

    public String getNombre() {
        return this.nombre;
    }


    public void setNombre(String nuevoNombre){
        this.nombre=nuevoNombre;
    }
}

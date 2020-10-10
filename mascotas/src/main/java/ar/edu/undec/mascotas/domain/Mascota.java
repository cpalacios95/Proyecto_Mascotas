package ar.edu.undec.mascotas.domain;

import ar.edu.undec.mascotas.exceptions.MascotaException;
import ar.edu.undec.mascotas.validations.MascotaValidation;

import java.time.LocalDate;

public class Mascota {

    private String nombre;
    private LocalDate fechaNac;
    private String raza;
    private Cliente duenio;

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

    public void setFechaNac(LocalDate nuevaFechaNac) {
        this.fechaNac=nuevaFechaNac;
    }

    public void setRaza(String nuevaRaza) {
        this.raza=nuevaRaza;
    }

    public String getRaza() {
        return this.raza;
    }

    public LocalDate getFechaNac() {
        return this.fechaNac;
    }

    public Cliente getDuenio() {
        return this.duenio;
    }

    @Override
    public String toString() {
        return "Mascota: "+this.nombre+", Raza: "+this.raza+", ("+this.fechaNac+");";
    }
}

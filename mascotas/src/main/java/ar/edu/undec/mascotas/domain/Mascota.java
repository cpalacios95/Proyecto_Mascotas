package ar.edu.undec.mascotas.domain;

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

    public static Mascota getInstance(String nombre, String raza, LocalDate fechaNac) {
        return new Mascota(nombre,raza,fechaNac);
    }

    public String getNombre() {
        return this.nombre;
    }
}

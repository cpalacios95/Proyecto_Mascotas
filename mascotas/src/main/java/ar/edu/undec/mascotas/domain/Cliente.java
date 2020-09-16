package ar.edu.undec.mascotas.domain;

import java.time.LocalDate;

public class Cliente {

    private String apellido;
    private String nombre;
    private String dni;
    private LocalDate fechaNac;


    public Cliente(String apellido, String nombre, String dni, LocalDate fechaNac) {
        this.apellido = apellido;
        this.nombre= nombre;
        this.dni=dni;
        this.fechaNac= fechaNac;
    }

    public static Cliente getInstance(String apellido, String nombre, String dni, LocalDate fechaNac) {

        return new Cliente(apellido,nombre,dni,fechaNac);
    }

    public String getDni() {
       return this.dni;
    }
}

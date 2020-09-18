package ar.edu.undec.mascotas.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Cliente {

    private String apellido;
    private String nombre;
    private String dni;
    private LocalDate fechaNac;
    private List<Mascota> misMascotas;

    public Cliente(String apellido, String nombre, String dni, LocalDate fechaNac) {
        this.apellido = apellido;
        this.nombre= nombre;
        this.dni=dni;
        this.fechaNac= fechaNac;
        this.misMascotas= new ArrayList<>();
    }

    public static Cliente getInstance(String apellido, String nombre, String dni, LocalDate fechaNac) {

        return new Cliente(apellido,nombre,dni,fechaNac);
    }

    public String getDni() {
       return this.dni;
    }


    public boolean addMascotaCliente(Mascota mascota, boolean existe) {
        if(!existe)
            return false;
        misMascotas.add(mascota);
        return true;
    }
}

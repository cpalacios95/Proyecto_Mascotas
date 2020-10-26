package ar.edu.undec.mascotas.controller.dtomodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class MascotaDTO {

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("fechanac")
    private LocalDate fechaNac;

    @JsonProperty("raza")
    private String raza;

    public MascotaDTO(String nombre, LocalDate fechaNac, String raza) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.raza = raza;
    }


}

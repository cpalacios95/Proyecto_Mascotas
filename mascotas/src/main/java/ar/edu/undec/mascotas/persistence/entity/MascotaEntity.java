package ar.edu.undec.mascotas.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "mascotas")
@SequenceGenerator(name = "mascota_id_gen", initialValue = 1, sequenceName = "mascota_id_gen", allocationSize = 1)
public class MascotaEntity {

    @Id
    @Column(name = "idmascota")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mascota_id_gen")
    private Integer idMascota;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fechanac")
    private LocalDate fechaNac;

    @Column(name = "raza")
    private String raza;

    public MascotaEntity(){
    }

    public Integer getIdmascota() {
        return idMascota;
    }

    public void setIdmascota(Integer idmascota) {
        this.idMascota = idmascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}

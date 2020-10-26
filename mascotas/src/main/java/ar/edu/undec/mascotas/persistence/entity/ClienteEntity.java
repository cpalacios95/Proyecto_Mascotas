package ar.edu.undec.mascotas.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "clientes")
@SequenceGenerator(name = "cliente_id_gen", initialValue = 1, sequenceName = "cliente_id_gen", allocationSize = 1)
public class ClienteEntity {

    @Id
    @Column(name = "idcliente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_id_gen")
    private Integer idCliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "dni")
    private String dni;

    @Column(name = "fechanac")
    private LocalDate fechaNac;

    public ClienteEntity(){

    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }
}

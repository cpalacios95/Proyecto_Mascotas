package ar.edu.undec.mascotas.input;


import ar.edu.undec.mascotas.domain.Cliente;

import java.time.LocalDate;

public interface IModificarClienteInput {

    boolean modificarDni(Cliente cliente, String nuevoDni);
    boolean modificarApellido(Cliente cliente, String nuevoApellido);
    boolean modificarNombre(Cliente cliente, String nuevoNombre);
    boolean modificarFechaNac(Cliente cliente, LocalDate nuevaFechaNac);
}

package ar.edu.undec.mascotas.validations;

import ar.edu.undec.mascotas.exceptions.ClienteException;


import java.time.LocalDate;

public class ClienteValidation {

    public static void validarDatos(String apellido, String nombre, String dni, LocalDate fechaNac) throws ClienteException {
        if(apellido.length()==0) throw new ClienteException("El apellido del cliente no puede ser vacio");

        if(nombre.length()==0) throw new ClienteException("El nombre del cliente no puede ser vacio");

        if(fechaNac.isBefore(LocalDate.of(1920,1,1))) throw new ClienteException("La fecha de nacimiento del cliente no puede ser menor a 1990");

        if(fechaNac.isAfter(LocalDate.now())) throw new ClienteException("La fecha de nacimiento del cliente no puede ser menor a 1990");


    }
}

package ar.edu.undec.mascotas.usecaseunittest;

import Mockito.MockitoExtension;
import ar.edu.undec.mascotas.domain.Cliente;

import ar.edu.undec.mascotas.exceptions.ClienteException;
import ar.edu.undec.mascotas.repository.IModificarClienteRepository;
import ar.edu.undec.mascotas.usecase.ModificarClienteUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})


public class ModificarClienteUseCaseUnitTest {

    @Mock
    IModificarClienteRepository modificarClienteRepository;

    @Test
    void modificarCliente_documentoNoExiste_modificarDNI() throws ClienteException {

        Cliente cliente = Cliente.getInstance("Palacios", "Cristian", "39700483", LocalDate.of(1996,11,22));

        ModificarClienteUseCase modificarClienteUseCase = new ModificarClienteUseCase(modificarClienteRepository);

        String nuevoDni= "40069712";

        when(modificarClienteRepository.existeCliente(nuevoDni)).thenReturn(false);

        when(modificarClienteRepository.guardarCliente(cliente)).thenReturn(true);

        assertTrue(modificarClienteUseCase.modificarDni(cliente, nuevoDni));

    }

    @Test
    void modificarCliente_documentoExiste_noModificarDNI() throws ClienteException {

        Cliente cliente = Cliente.getInstance("Palacios", "Cristian", "39700483", LocalDate.of(1996,11,22));

        ModificarClienteUseCase modificarClienteUseCase = new ModificarClienteUseCase(modificarClienteRepository);

        String nuevoDni= "40069712";

        when(modificarClienteRepository.existeCliente(nuevoDni)).thenReturn(true);

        when(modificarClienteRepository.guardarCliente(cliente)).thenReturn(false);

        assertFalse(modificarClienteUseCase.modificarDni(cliente, nuevoDni));

    }

    @Test
    void modificarCliente_modificarApellido() throws ClienteException {

        Cliente cliente = Cliente.getInstance("Palacios", "Cristian", "39700483", LocalDate.of(1996,11,22));

        ModificarClienteUseCase modificarClienteUseCase = new ModificarClienteUseCase(modificarClienteRepository);

        String nuevoApellido = "Rodriguez";

        when(modificarClienteRepository.guardarCliente(cliente)).thenReturn(false);

        assertTrue(modificarClienteUseCase.modificarApellido(cliente, nuevoApellido));

    }

    @Test
    void modificarCliente_modificarNombre() throws ClienteException {

        Cliente cliente = Cliente.getInstance("Palacios", "Cristian", "39700483", LocalDate.of(1996,11,22));

        ModificarClienteUseCase modificarClienteUseCase = new ModificarClienteUseCase(modificarClienteRepository);

        String nuevoNombre = "Matias Nahuel";

        when(modificarClienteRepository.guardarCliente(cliente)).thenReturn(false);

        assertTrue(modificarClienteUseCase.modificarNombre(cliente, nuevoNombre));

    }

    @Test
    void modificarCliente_modificarFechaNac() throws ClienteException {

        Cliente cliente = Cliente.getInstance("Palacios", "Cristian", "39700483", LocalDate.of(1996,11,22));

        ModificarClienteUseCase modificarClienteUseCase = new ModificarClienteUseCase(modificarClienteRepository);

        LocalDate nuevaFechaNac= LocalDate.of(1990,2, 4);

        when(modificarClienteRepository.guardarCliente(cliente)).thenReturn(false);

        assertTrue(modificarClienteUseCase.modificarFechaNac(cliente, nuevaFechaNac));

    }
}

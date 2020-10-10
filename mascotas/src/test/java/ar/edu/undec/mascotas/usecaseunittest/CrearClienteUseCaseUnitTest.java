package ar.edu.undec.mascotas.usecaseunittest;

import Mockito.MockitoExtension;
import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.exceptions.ClienteException;
import ar.edu.undec.mascotas.repository.ICrearClienteRepository;
import ar.edu.undec.mascotas.usecase.CrearClienteUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

@ExtendWith({MockitoExtension.class})

public class CrearClienteUseCaseUnitTest {


    @Mock
    ICrearClienteRepository crearClienteRepository;

    @Test
    void crearCliente_clienteNoExiste_crearCliente() throws ClienteException {

        Cliente cliente = Cliente.getInstance("Palacios", "Cristian", "39700483", LocalDate.of(1996,11,22));

        CrearClienteUseCase crearClienteUseCase = new CrearClienteUseCase(crearClienteRepository);

        when(crearClienteRepository.existeCliente(cliente.getDni())).thenReturn(false);
        when(crearClienteRepository.guardarCliente(cliente)).thenReturn(true);

        assertTrue(crearClienteUseCase.crearCliente(cliente));

    }

    @Test
    void crearCliente_clienteExiste_noCrearCliente() throws ClienteException {

        Cliente cliente = Cliente.getInstance("Palacios", "Cristian", "39700483", LocalDate.of(1996,11,22));

        CrearClienteUseCase crearClienteUseCase = new CrearClienteUseCase(crearClienteRepository);

        when(crearClienteRepository.existeCliente(cliente.getDni())).thenReturn(true);

        assertThrows(ClienteException.class, ()-> crearClienteUseCase.crearCliente(cliente));

    }

    @Test
    void crearCliete_apellidoVacio(){

        assertThrows(ClienteException.class, () -> Cliente.getInstance("", "Cristian", "39700483", LocalDate.of(2005, 11, 12)));
    }

    @Test
    void crearCliete_apellidoNulo(){

        assertThrows(NullPointerException.class, () -> Cliente.getInstance(null, "Cristian", "39700483", LocalDate.of(2005, 11, 12)));
    }

    @Test
    void crearCliete_nombreVacio(){

        assertThrows(ClienteException.class, () -> Cliente.getInstance("Palacios", "", "39700483", LocalDate.of(2005, 11, 12)));
    }
    @Test
    void crearCliete_nombreNulo(){

        assertThrows(NullPointerException.class, () -> Cliente.getInstance("Palacios", null, "39700483", LocalDate.of(2005, 11, 12)));
    }

    @Test
    void crearCliente_fachaInvalidaMenorDeEdad(){

        assertThrows(ClienteException.class, () -> Cliente.getInstance("Palacios", "Cristian", "39700483",LocalDate.of(2005, 11, 12)));
    }

    @Test
    void crearCliente_fachaInvalidaMayorAFechaLimite(){

        assertThrows(ClienteException.class, () -> Cliente.getInstance("Palacios", "Cristian", "39700483",LocalDate.of(2022, 11, 12)));
    }

    @Test
    void crearCliente_DniInvalido(){

        assertThrows(ClienteException.class, () -> Cliente.getInstance("Palacios", "Cristian", "39700483",LocalDate.of(2022, 11, 12)));
    }

}

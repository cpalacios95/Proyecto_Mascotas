package ar.edu.undec.mascotas.usecaseunittest;

import Mockito.MockitoExtension;
import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.exceptions.ClienteException;
import ar.edu.undec.mascotas.repository.IConsultarClienteRepository;
import ar.edu.undec.mascotas.usecase.ConsultarClienteUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class ConsultarClienteUseCaseUnitTest {


    @Mock
    IConsultarClienteRepository iConsultarClienteRepository;

    @Test
    public void testConsultarClientePorDNI_clienteExiste() throws ClienteException {

        Cliente cliente = Cliente.getInstance("Palacios", "Cristian", "39700483", LocalDate.of(1996,11,22));

        ConsultarClienteUseCase consultarClienteUseCase = new ConsultarClienteUseCase(iConsultarClienteRepository);

        when(iConsultarClienteRepository.existeCliente(cliente.getDni())).thenReturn(true);
        when(iConsultarClienteRepository.obtenerCliente(cliente.getDni())).thenReturn(cliente);

        String expected = "Cliente: Palacios Cristian, DNI: 39700483, (1996-11-22)";

        assertEquals(expected,consultarClienteUseCase.getDatosCliente(cliente.getDni()));

    }

    @Test
    public void testConsultarClientePorDNI_clienteNoExiste() throws ClienteException {

        Cliente cliente = Cliente.getInstance("Palacios", "Cristian", "39700483", LocalDate.of(1996,11,22));

        ConsultarClienteUseCase consultarClienteUseCase = new ConsultarClienteUseCase(iConsultarClienteRepository);

        when(iConsultarClienteRepository.existeCliente(cliente.getDni())).thenReturn(false);

        String expected = "El cliente no existe";

        assertEquals(expected,consultarClienteUseCase.getDatosCliente(cliente.getDni()));

    }

    //Faltan agregar test de consultar mascotas por cliente...

}
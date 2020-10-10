package ar.edu.undec.mascotas.usecaseunittest;

import Mockito.MockitoExtension;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.exceptions.MascotaException;
import ar.edu.undec.mascotas.repository.IConsultarMascotaRepository;
import ar.edu.undec.mascotas.usecase.ConsultarMascotaUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith({MockitoExtension.class})
public class ConsultarMascotaUseCaseUnitTest {


    @Mock
    IConsultarMascotaRepository iConsultarMascotaRepository;

    @Test
    public void testConsultarMascotaPorNombre_MascotaExite() throws MascotaException {

        Mascota mascota01 = Mascota.getInstance("Ringo", "Labrador", LocalDate.of(2005,11,1));

        ConsultarMascotaUseCase consultarMascotaUseCase = new ConsultarMascotaUseCase (iConsultarMascotaRepository);

        when(iConsultarMascotaRepository.existeMascota(mascota01.getNombre())).thenReturn(true);
        when(iConsultarMascotaRepository.obtenerMascota(mascota01.getNombre())).thenReturn(mascota01);

        String expected = "Mascota: Ringo, Raza: Labrador, (2005-11-01);";

        assertEquals(expected, consultarMascotaUseCase.getDatosMascota(mascota01.getNombre()));
    }

    @Test
    public void testConsultarMascotaPorNombre_mascotaNoExite() throws MascotaException {

        Mascota mascota01 = Mascota.getInstance("Ringo", "Labrador", LocalDate.of(2005,11,1));

        ConsultarMascotaUseCase consultarMascotaUseCase = new ConsultarMascotaUseCase (iConsultarMascotaRepository);

        when(iConsultarMascotaRepository.existeMascota(mascota01.getNombre())).thenReturn(false);

        String expected = "La Mascota no existe";

        assertEquals(expected, consultarMascotaUseCase.getDatosMascota(mascota01.getNombre()));
    }


}

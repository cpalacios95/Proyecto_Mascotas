package ar.edu.undec.mascotas.usecaseunittest;

import Mockito.MockitoExtension;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.exceptions.MascotaException;
import ar.edu.undec.mascotas.repository.ICrearMascotaRepository;
import ar.edu.undec.mascotas.usecase.CrearMascotaUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.DateTimeException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})

public class CrearMascotaUseCaseUnitTest {

    @Mock
    ICrearMascotaRepository crearMascotaRepository;

    @Test
    void crearMascota_mascotaNoExiste_crearMascota() throws MascotaException {

        Mascota mascota01= Mascota.getInstance("Ringo", "Labrador", LocalDate.of(2019, 10, 22));

        CrearMascotaUseCase crearMascotaUseCase = new CrearMascotaUseCase(crearMascotaRepository);

        when(crearMascotaRepository.existeMascota(mascota01.getNombre())).thenReturn(false);
        when(crearMascotaRepository.guardarMascota(mascota01)).thenReturn(true);

        assertTrue(crearMascotaUseCase.crearMascota(mascota01));

    }

    @Test
    void crearMascota_mascotaExiste_noCrearMascota() throws MascotaException {

        Mascota mascota01 = Mascota.getInstance("Ringo", "Labrador", LocalDate.of(2005,11,1));

        CrearMascotaUseCase mascotaUseCase = new CrearMascotaUseCase(crearMascotaRepository);

        when(crearMascotaRepository.existeMascota(mascota01.getNombre())).thenReturn(true);
        when(crearMascotaRepository.guardarMascota(mascota01)).thenReturn(false);

        assertFalse(mascotaUseCase.crearMascota(mascota01));

    }

    @Test
    void crearMascota_nombreNulo(){

        assertThrows(NullPointerException.class, () -> Mascota.getInstance(null, "Labrador", LocalDate.of(2005, 11, 12)));
    }

    @Test
    void crearMascota_nombreVacio(){

        assertThrows(MascotaException.class, () -> Mascota.getInstance("", "Labrador", LocalDate.of(2005, 11, 12)));
    }

    @Test
    void crearMascota_razaNulo(){

        assertThrows(NullPointerException.class, () -> Mascota.getInstance("Ringo", null, LocalDate.of(2005, 11, 12)));
    }

    @Test
    void crearMascota_razaVacio(){

        assertThrows(MascotaException.class, () -> Mascota.getInstance("Ringo", "", LocalDate.of(2005, 11, 12)));
    }

    @Test
    void crearMascota_fachaInvalidaMenorAFechaLimite(){

        assertThrows(MascotaException.class, () -> Mascota.getInstance("Ringo", "Labrador", LocalDate.of(1988, 11, 12)));
    }

    @Test
    void crearMascota_fachaInvalidaMayorAFechaLimite(){

        assertThrows(MascotaException.class, () -> Mascota.getInstance("Ringo", "Labrador", LocalDate.of(2021, 11, 12)));
    }
}

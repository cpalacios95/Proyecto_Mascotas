package ar.edu.undec.mascotas.usecaseunittest;

import Mockito.MockitoExtension;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.repository.ICrearMascotaRepository;
import ar.edu.undec.mascotas.usecase.CrearMascotaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})

public class CrearMascotaUseCaseUnitTest {

    @Mock
    ICrearMascotaRepository crearMascotaRepository;

    @Test
    void crearMascota_mascotaNoExiste_crearMascota(){

        Mascota mascota01= Mascota.getInstance("Ringo", "Labrador", LocalDate.of(2005, 11, 12));

        CrearMascotaUseCase crearMascotaUseCase = new CrearMascotaUseCase(crearMascotaRepository);

        when(crearMascotaRepository.existeMascota(mascota01.getNombre())).thenReturn(false);
        when(crearMascotaRepository.guardarMascota(mascota01)).thenReturn(true);

        Assertions.assertTrue(crearMascotaUseCase.crearMascota(mascota01));

    }

}
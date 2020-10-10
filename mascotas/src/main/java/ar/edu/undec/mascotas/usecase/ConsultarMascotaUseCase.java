package ar.edu.undec.mascotas.usecase;

import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.input.IConsultarMoscotaInput;
import ar.edu.undec.mascotas.repository.IConsultarMascotaRepository;


public class ConsultarMascotaUseCase implements IConsultarMoscotaInput {

    private IConsultarMascotaRepository iConsultarMascotaRepository;

    public ConsultarMascotaUseCase(IConsultarMascotaRepository iConsultarMascotaRepository) {
        this.iConsultarMascotaRepository = iConsultarMascotaRepository;
    }


    @Override
    public String getDatosMascota(String nombre) {

        if(iConsultarMascotaRepository.existeMascota(nombre)){
            Mascota m01= iConsultarMascotaRepository.obtenerMascota(nombre);
            return m01.toString();
        }

        return "La Mascota no existe";
    }
}

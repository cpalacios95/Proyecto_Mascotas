package ar.edu.undec.mascotas.usecase;

import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.exceptions.AsignarClienteException;
import ar.edu.undec.mascotas.input.IAsignarClienteAMascotaInput;
import ar.edu.undec.mascotas.repository.IAsignarClienteAMascotaReposotory;

public class AsignarMascotaUseCase implements IAsignarClienteAMascotaInput {

    IAsignarClienteAMascotaReposotory iAsignarClienteAMascotaReposotory;


    public AsignarMascotaUseCase(IAsignarClienteAMascotaReposotory asignarClienteAMascotaReposotory){
        this.iAsignarClienteAMascotaReposotory = asignarClienteAMascotaReposotory;
    }

    @Override
    public boolean asignarClienteAMascota(Cliente cliente, String nombreMascota) throws AsignarClienteException {

        Mascota mascota = iAsignarClienteAMascotaReposotory.buscarMascota(nombreMascota);

        if(iAsignarClienteAMascotaReposotory.tieneDuenio(mascota)) {

            throw new AsignarClienteException("La mascota ya tiene un cliente");
        }else {
            iAsignarClienteAMascotaReposotory.asignarCliente(cliente);
            return true;
        }
    }
}

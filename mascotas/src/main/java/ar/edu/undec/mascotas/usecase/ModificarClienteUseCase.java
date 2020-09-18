package ar.edu.undec.mascotas.usecase;

import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.input.IModificarClienteInput;
import ar.edu.undec.mascotas.repository.IModificarClienteRepository;

import java.time.LocalDate;

public class ModificarClienteUseCase implements IModificarClienteInput {

    private IModificarClienteRepository modificarClienteRepository;

    public ModificarClienteUseCase(IModificarClienteRepository modifcarClienteRepository) {

        this.modificarClienteRepository = modifcarClienteRepository;
    }

    @Override
    public boolean modificarDni(Cliente cliente, String nuevoDni) {

        if(modificarClienteRepository.existeCliente(nuevoDni))
            return false;
        else {
            cliente.setDni(nuevoDni);
            modificarClienteRepository.guardarCliente(cliente);
            return true;
        }
    }

    @Override
    public boolean modificarApellido(Cliente cliente, String nuevoApellido) {
        cliente.setApellido(nuevoApellido);
        modificarClienteRepository.guardarCliente(cliente);
        return true;
    }

    @Override
    public boolean modificarNombre(Cliente cliente, String nuevoNombre) {
        cliente.setNombre(nuevoNombre);
        modificarClienteRepository.guardarCliente(cliente);
        return true;
    }

    @Override
    public boolean modificarFechaNac(Cliente cliente, LocalDate nuevaFechaNac) {
        cliente.setFechaNac(nuevaFechaNac);
        modificarClienteRepository.guardarCliente(cliente);
        return true;
    }
}

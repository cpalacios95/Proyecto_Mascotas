package ar.edu.undec.mascotas.persistence;

import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.persistence.crud.ICrearClienteCRUD;
import ar.edu.undec.mascotas.persistence.crud.ICrearMascotaCRUD;
import ar.edu.undec.mascotas.persistence.entity.ClienteEntity;
import ar.edu.undec.mascotas.repository.ICrearClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ICrearClienteRepositoryImplementation implements ICrearClienteRepository {

    @Autowired
    ICrearClienteCRUD iCrearClienteCRUD;

    @Override
    public boolean existeCliente(String dni) {
        return false;
    }


    @Override
    public boolean guardarCliente(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNombre(cliente.getNombre());
        clienteEntity.setApellido(cliente.getApellido());
        clienteEntity.setDni(cliente.getDni());
        clienteEntity.setFechaNac(cliente.getFechaNac());

        return this.iCrearClienteCRUD.save(clienteEntity).getIdCliente()!=null;
    }


}

package ar.edu.undec.mascotas.persistence;


import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.persistence.crud.ICrearMascotaCRUD;
import ar.edu.undec.mascotas.persistence.entity.MascotaEntity;
import ar.edu.undec.mascotas.repository.ICrearMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ICrearMascotaRepositoryImplementation implements ICrearMascotaRepository {

    @Autowired
    ICrearMascotaCRUD crearMascotaCRUD;

    @Override
    public boolean existeMascota(String nombreMascota) {
        return false;
    }

    @Override
    public boolean guardarMascota(Mascota mascota) {
        MascotaEntity mascotaEntity = new MascotaEntity();
        mascotaEntity.setNombre(mascota.getNombre());
        mascotaEntity.setFechaNac(mascota.getFechaNac());
        mascotaEntity.setRaza(mascota.getRaza());

        return this.crearMascotaCRUD.save(mascotaEntity).getIdmascota()!=null;
    }
}

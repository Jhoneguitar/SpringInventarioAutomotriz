package com.nexos.servicio;

import com.nexos.dao.CargoDao;
import com.nexos.domain.Cargo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CargoServiceImpl implements CargoService{

    @Autowired
    private CargoDao cargoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Cargo> listarCargos() {
        return cargoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Cargo cargo) {
        cargoDao.save(cargo);
    }

    @Override
    @Transactional
    public void eliminar(Cargo cargo) {
        cargoDao.delete(cargo);
    }

    @Override
    @Transactional(readOnly = true)
    public Cargo encontrarProducto(Cargo cargo) {
        return cargoDao.findById(cargo.getIdCargo()).orElse(null);
    }
    
}

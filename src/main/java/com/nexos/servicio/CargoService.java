package com.nexos.servicio;

import com.nexos.domain.Cargo;
import java.util.List;

public interface CargoService {
        
    public List<Cargo> listarCargos();
    
    public void guardar(Cargo cargo);
    
    public void eliminar(Cargo cargo);
    
    public Cargo encontrarProducto(Cargo cargo);
}

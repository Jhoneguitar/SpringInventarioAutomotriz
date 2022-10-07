package com.nexos.servicio;

import com.nexos.domain.ModificacionProducto;
import java.util.List;

public interface ModificacionProductoService {
        
    public List<ModificacionProducto> listarModificaciones();
    
    public void guardar(ModificacionProducto modificacionProducto);
    
    public void eliminar(ModificacionProducto modificacionProducto);
    
    public ModificacionProducto encontrarProducto(ModificacionProducto modificacionProducto);
}

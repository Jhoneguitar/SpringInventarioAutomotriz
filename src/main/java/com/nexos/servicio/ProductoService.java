package com.nexos.servicio;

import com.nexos.domain.Producto;
import java.util.List;

public interface ProductoService {
    
    //ensayo para búsqueda, original sin parámetros
    public List<Producto> listarProductos(String palabraClave);
    
    public void guardar(Producto producto);
    
    public void eliminar(Producto producto);
    
    public Producto encontrarProducto(Producto producto);
    
}

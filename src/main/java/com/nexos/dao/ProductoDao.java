package com.nexos.dao;

import com.nexos.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoDao extends JpaRepository<Producto, Long>{
    
    @Query("SELECT p FROM Producto p WHERE" 
            + " CONCAT(p.nombreProducto, p.cantidadProducto, p.fechaIngProducto, p.usuario.nombreUsuario)"
            + " LIKE %?1%")
    public List<Producto> findAll(String palabraClave);
    
}

package com.nexos.servicio;

import com.nexos.dao.ModificacionProductoDao;
import com.nexos.domain.ModificacionProducto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModificacionProductoServiceImpl implements ModificacionProductoService{
    
    @Autowired
    private ModificacionProductoDao modificarProductoDao;

    @Override
    @Transactional(readOnly = true)
    public List<ModificacionProducto> listarModificaciones() {
        return modificarProductoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(ModificacionProducto modificacionProducto) {
        modificarProductoDao.save(modificacionProducto);
    }

    @Override
    @Transactional
    public void eliminar(ModificacionProducto modificacionProducto) {
        modificarProductoDao.delete(modificacionProducto);
    }

    @Override
    @Transactional(readOnly = true)
    public ModificacionProducto encontrarProducto(ModificacionProducto modificacionProducto) {
        return modificarProductoDao.findById(modificacionProducto.getIdModProducto()).orElse(null);
    }
    
}

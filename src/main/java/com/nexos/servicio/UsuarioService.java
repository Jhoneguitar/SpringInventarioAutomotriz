package com.nexos.servicio;

import com.nexos.domain.Usuario;
import java.util.List;

public interface UsuarioService {
    
        public List<Usuario> listarUsuarios();
    
    public void guardar(Usuario usuario);
    
    public void eliminar(Usuario usuario);
    
    public Usuario encontrarUsuario(Usuario usuario);
    
}

package com.nexos.web;

import com.nexos.domain.ModificacionProducto;
import com.nexos.domain.Producto;
import com.nexos.servicio.ModificacionProductoService;
import com.nexos.servicio.ProductoService;
import com.nexos.servicio.UsuarioService;
import com.nexos.util.Utiles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ModificacionProductoService modificacionProductoService;

    @GetMapping("/")
    public String inicio(Model model, @Param("palabraClave") String palabraClave) {
        //String palabraClave = "radiador";
        var productos = productoService.listarProductos(palabraClave);
        var usuarios = usuarioService.listarUsuarios();
        model.addAttribute("productos", productos);
        model.addAttribute("palabraClave", palabraClave);
        model.addAttribute("usuarios", usuarios);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Producto producto) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Producto producto, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }

        productoService.guardar(producto);

        return "redirect:/";
    }

    @PostMapping("/editarProducto")
    public String editarProducto(Producto producto, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }

        ModificacionProducto modificacionProducto = new ModificacionProducto();
        modificacionProducto.setProducto(producto);
        modificacionProducto.setUsuario(producto.getUsuario());
        modificacionProducto.setFechaModProducto(Utiles.getCurrentDate());

        Producto ProductoNoMod = productoService.encontrarProducto(producto);
        producto.setUsuario(ProductoNoMod.getUsuario());

        productoService.guardar(producto);
        modificacionProductoService.guardar(modificacionProducto);
        return "redirect:/";
    }

    @PostMapping("/revisarUsuario")
    public String revisarUsuario(Producto producto) {

        var productoUser = productoService.encontrarProducto(producto);
        if (productoUser.getUsuario().getIdUsuario().equals(producto.getUsuario().getIdUsuario())) {

            var modificaciones = modificacionProductoService.listarModificaciones();
            if (modificaciones != null && !modificaciones.isEmpty()) {
                for (ModificacionProducto modificacion : modificaciones) {
                    if (modificacion.getProducto().getIdProducto().equals(producto.getIdProducto())) {
                        modificacionProductoService.eliminar(modificacion);
                    }
                }
            }
            this.eliminar(producto);
            return "redirect:/";
        } else {
            return "accesoDenegado";
        }
    }

    @GetMapping("/editar/{idProducto}")
    public String editar(Producto producto, Model model) {
        producto = productoService.encontrarProducto(producto);
        model.addAttribute("producto", producto);

        var usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "modificar";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String eliminar(Producto producto, Model model) {
        producto = productoService.encontrarProducto(producto);
        model.addAttribute("producto", producto);

        var usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);

        return "eliminar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Producto producto) {
        productoService.eliminar(producto);
        return "redirect:/";
    }
}

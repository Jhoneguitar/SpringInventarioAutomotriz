package com.nexos.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable{
    
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto; 
    private String nombreProducto;
    private int cantidadProducto;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechaIngProducto;
    
    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario usuario;
}

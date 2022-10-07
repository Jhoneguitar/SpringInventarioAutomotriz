package com.nexos.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "modificacion_producto")
public class ModificacionProducto implements Serializable{
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModProducto;
    
    @JoinColumn(name = "id_producto")
    @ManyToOne
    private Producto producto;
    
    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario usuario;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechaModProducto;
    
}

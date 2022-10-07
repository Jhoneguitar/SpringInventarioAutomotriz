package com.nexos.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    private String nombreUsuario;
    
    private int edadUsuario;
    
    @JoinColumn(name = "id_cargo")
    @ManyToOne
    private Cargo cargo;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaIngUsuario;
    
    
//    @OneToMany
//    @JoinColumn(name = "id_usuario")
//    private List<Producto> productos;
}

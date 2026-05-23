package com.asignatura.app.modelo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    //  PROPIEDADES

    private String cedula;
    @Column(name = "password")
    private  String clave;
    @Column(name = "name")
    private  String nombre;
    private String email;
}

package com.asignatura.app.modelo;


import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "users")
@Data
public class Usuario implements Serializable {
    //PROPIEDADES
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false, length = 15)
    private String id;
    @NotEmpty
    private String cedula;
    @Column(name = "password")
    @NotEmpty
    private  String clave;
    @Column(name = "name")
    @NotEmpty
    private  String nombre;
    @NotEmpty
    private String email;
    @NotEmpty
    private String role;
    @NotEmpty
    private String status;

    @Column(name = "created_at", nullable = true, updatable = false)
    Timestamp created_at;

    @Column(name = "updated_at", nullable = true, updatable = true)
    Timestamp updated_at;

    @PrePersist
    public void prePersist() {
        Timestamp now = Timestamp.from(Instant.now());

        if (created_at == null) {
            created_at = now;
        }

        if (updated_at == null) {
            updated_at = now;
        }
    }

    @PreUpdate
    public void preUpdate() {
        updated_at = Timestamp.from(Instant.now());
    }

}

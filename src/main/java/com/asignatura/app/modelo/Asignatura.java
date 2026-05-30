package com.asignatura.app.modelo;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "asignatura")
@Data
public class Asignatura implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @NotEmpty
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotEmpty
    @Column(name = "nombreCompleto", nullable = false, length = 200)
    private String nombreCompleto;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "areaConocimiento", length = 100)
    private String areaConocimiento;

    @Column(name = "carrera", length = 100)
    private String carrera;

    @NotNull
    @Column(name = "numeroCreditos", nullable = false)
    private Integer numeroCreditos;

    @Column(name = "contenidoTematico", columnDefinition = "TEXT")
    private String contenidoTematico;

    @Column(name = "semestre")
    private Integer semestre;

    @Column(name = "profesor", length = 100)
    private String profesor;

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

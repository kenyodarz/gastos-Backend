package com.cdm.gastos.models;

import javax.persistence.*;

@Entity
@Table(name = "descripcion")
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDescripcion;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private String tipoDescripcion;

    public Description() {
    }

    public Long getIdDescripcion() {
        return idDescripcion;
    }

    public void setIdDescripcion(Long idDescripcion) {
        this.idDescripcion = idDescripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoDescripcion() {
        return tipoDescripcion;
    }

    public void setTipoDescripcion(String tipoDescripcion) {
        this.tipoDescripcion = tipoDescripcion;
    }
}

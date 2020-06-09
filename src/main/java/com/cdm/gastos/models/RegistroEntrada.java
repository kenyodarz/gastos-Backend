package com.cdm.gastos.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "registro_entrada",uniqueConstraints = {
        @UniqueConstraint(columnNames = "observaciones"),
}
)
public class RegistroEntrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistro;
    @Column

    private String observaciones;
    @OneToOne
    @JoinColumn(name ="idDescripcion")
    private Description description;
    @Column
    private String tipo;
    @Column
    private LocalDate fecha;
    @Column
    private  Double cantidad;
    @OneToOne
    @JoinColumn(name = "id")
    public User users;
    @Column
    private Boolean cerrado;
    @OneToOne
    @JoinColumn(name = "idInforme")
    private Informe informe;

    public RegistroEntrada() {
    }

    public Long getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Long idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Boolean getCerrado() {
        return cerrado;
    }

    public void setCerrado(Boolean cerrado) {
        this.cerrado = cerrado;
    }

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }
}

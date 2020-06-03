package com.cdm.gastos.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "saldo")
public class Saldo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSaldo;
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
    @Column
    public String users;
    @Column
    private Boolean cerrado;
    @OneToOne
    @JoinColumn(name = "idRegistro")
    private RegistroEntrada registroEntrada;

    public Saldo() {}

    public Long getIdSaldo() {
        return idSaldo;
    }

    public void setIdSaldo(Long idSaldo) {
        this.idSaldo = idSaldo;
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

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public Boolean getCerrado() {
        return cerrado;
    }

    public void setCerrado(Boolean cerrado) {
        this.cerrado = cerrado;
    }

    public RegistroEntrada getRegistroEntrada() {
        return registroEntrada;
    }

    public void setRegistroEntrada(RegistroEntrada registroEntrada) {
        this.registroEntrada = registroEntrada;
    }
}

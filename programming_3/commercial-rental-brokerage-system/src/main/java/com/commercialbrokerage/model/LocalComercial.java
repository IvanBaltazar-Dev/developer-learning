package com.commercialbrokerage.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LocalComercial {

    private long id;
    private String codigoLocal;
    private String direccion;
    private String distrito;
    private String referencia;
    private double areaMetrosCuadrados;
    private double precioReferencialMensual;
    private String estadoConservacion;
    private boolean disponible;
    private LocalDateTime fechaRegistro;
    private Propietario propietario;
    private List<Captacion> captaciones = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigoLocal() {
        return codigoLocal;
    }

    public void setCodigoLocal(String codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public double getAreaMetrosCuadrados() {
        return areaMetrosCuadrados;
    }

    public void setAreaMetrosCuadrados(double areaMetrosCuadrados) {
        this.areaMetrosCuadrados = areaMetrosCuadrados;
    }

    public double getPrecioReferencialMensual() {
        return precioReferencialMensual;
    }

    public void setPrecioReferencialMensual(double precioReferencialMensual) {
        this.precioReferencialMensual = precioReferencialMensual;
    }

    public String getEstadoConservacion() {
        return estadoConservacion;
    }

    public void setEstadoConservacion(String estadoConservacion) {
        this.estadoConservacion = estadoConservacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public List<Captacion> getCaptaciones() {
        return captaciones;
    }

    public void setCaptaciones(List<Captacion> captaciones) {
        this.captaciones = captaciones;
    }
}


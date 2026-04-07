package com.commercialbrokerage.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Propietario {

    private long id;
    private String nombres;
    private String apellidos;
    private String documentoIdentidad;
    private String correo;
    private String telefono;
    private String direccionContacto;
    private LocalDateTime fechaRegistro;
    private List<LocalComercial> localesComerciales = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccionContacto() {
        return direccionContacto;
    }

    public void setDireccionContacto(String direccionContacto) {
        this.direccionContacto = direccionContacto;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<LocalComercial> getLocalesComerciales() {
        return localesComerciales;
    }

    public void setLocalesComerciales(List<LocalComercial> localesComerciales) {
        this.localesComerciales = localesComerciales;
    }
}


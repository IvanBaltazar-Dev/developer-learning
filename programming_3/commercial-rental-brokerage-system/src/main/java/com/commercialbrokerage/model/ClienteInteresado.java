package com.commercialbrokerage.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClienteInteresado {

    private long id;
    private String nombres;
    private String apellidos;
    private String documentoIdentidad;
    private String correo;
    private String telefono;
    private String rubroNegocio;
    private String requerimientoLocal;
    private LocalDateTime fechaRegistro;
    private List<ConsultaInteres> consultasInteres = new ArrayList<>();
    private List<Visita> visitas = new ArrayList<>();
    private List<SolicitudAlquiler> solicitudesAlquiler = new ArrayList<>();

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

    public String getRubroNegocio() {
        return rubroNegocio;
    }

    public void setRubroNegocio(String rubroNegocio) {
        this.rubroNegocio = rubroNegocio;
    }

    public String getRequerimientoLocal() {
        return requerimientoLocal;
    }

    public void setRequerimientoLocal(String requerimientoLocal) {
        this.requerimientoLocal = requerimientoLocal;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<ConsultaInteres> getConsultasInteres() {
        return consultasInteres;
    }

    public void setConsultasInteres(List<ConsultaInteres> consultasInteres) {
        this.consultasInteres = consultasInteres;
    }

    public List<Visita> getVisitas() {
        return visitas;
    }

    public void setVisitas(List<Visita> visitas) {
        this.visitas = visitas;
    }

    public List<SolicitudAlquiler> getSolicitudesAlquiler() {
        return solicitudesAlquiler;
    }

    public void setSolicitudesAlquiler(List<SolicitudAlquiler> solicitudesAlquiler) {
        this.solicitudesAlquiler = solicitudesAlquiler;
    }
}


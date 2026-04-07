package com.commercialbrokerage.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SolicitudAlquiler {

    private long id;
    private LocalDateTime fechaSolicitud;
    private String estado;
    private String plazoDeseado;
    private String observaciones;
    private ClienteInteresado clienteInteresado;
    private Captacion captacion;
    private AgenteInmobiliario agenteInmobiliario;
    private List<DocumentoSolicitud> documentosSolicitud = new ArrayList<>();
    private List<EvaluacionSolicitud> evaluacionesSolicitud = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPlazoDeseado() {
        return plazoDeseado;
    }

    public void setPlazoDeseado(String plazoDeseado) {
        this.plazoDeseado = plazoDeseado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public ClienteInteresado getClienteInteresado() {
        return clienteInteresado;
    }

    public void setClienteInteresado(ClienteInteresado clienteInteresado) {
        this.clienteInteresado = clienteInteresado;
    }

    public Captacion getCaptacion() {
        return captacion;
    }

    public void setCaptacion(Captacion captacion) {
        this.captacion = captacion;
    }

    public AgenteInmobiliario getAgenteInmobiliario() {
        return agenteInmobiliario;
    }

    public void setAgenteInmobiliario(AgenteInmobiliario agenteInmobiliario) {
        this.agenteInmobiliario = agenteInmobiliario;
    }

    public List<DocumentoSolicitud> getDocumentosSolicitud() {
        return documentosSolicitud;
    }

    public void setDocumentosSolicitud(List<DocumentoSolicitud> documentosSolicitud) {
        this.documentosSolicitud = documentosSolicitud;
    }

    public List<EvaluacionSolicitud> getEvaluacionesSolicitud() {
        return evaluacionesSolicitud;
    }

    public void setEvaluacionesSolicitud(List<EvaluacionSolicitud> evaluacionesSolicitud) {
        this.evaluacionesSolicitud = evaluacionesSolicitud;
    }
}


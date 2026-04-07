package com.commercialbrokerage.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Captacion {

    private long id;
    private String codigoCaptacion;
    private LocalDateTime fechaCaptacion;
    private LocalDateTime fechaCierre;
    private String estado;
    private String observaciones;
    private LocalComercial localComercial;
    private AgenteInmobiliario agenteResponsable;
    private Broker brokerSupervisor;
    private List<ConsultaInteres> consultasInteres = new ArrayList<>();
    private List<Visita> visitas = new ArrayList<>();
    private List<SolicitudAlquiler> solicitudesAlquiler = new ArrayList<>();
    private List<ReasignacionCaptacion> reasignaciones = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigoCaptacion() {
        return codigoCaptacion;
    }

    public void setCodigoCaptacion(String codigoCaptacion) {
        this.codigoCaptacion = codigoCaptacion;
    }

    public LocalDateTime getFechaCaptacion() {
        return fechaCaptacion;
    }

    public void setFechaCaptacion(LocalDateTime fechaCaptacion) {
        this.fechaCaptacion = fechaCaptacion;
    }

    public LocalDateTime getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDateTime fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalComercial getLocalComercial() {
        return localComercial;
    }

    public void setLocalComercial(LocalComercial localComercial) {
        this.localComercial = localComercial;
    }

    public AgenteInmobiliario getAgenteResponsable() {
        return agenteResponsable;
    }

    public void setAgenteResponsable(AgenteInmobiliario agenteResponsable) {
        this.agenteResponsable = agenteResponsable;
    }

    public Broker getBrokerSupervisor() {
        return brokerSupervisor;
    }

    public void setBrokerSupervisor(Broker brokerSupervisor) {
        this.brokerSupervisor = brokerSupervisor;
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

    public List<ReasignacionCaptacion> getReasignaciones() {
        return reasignaciones;
    }

    public void setReasignaciones(List<ReasignacionCaptacion> reasignaciones) {
        this.reasignaciones = reasignaciones;
    }
}


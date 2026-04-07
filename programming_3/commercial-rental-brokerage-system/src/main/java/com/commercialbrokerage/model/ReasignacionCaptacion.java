package com.commercialbrokerage.model;

import java.time.LocalDateTime;

public class ReasignacionCaptacion {

    private long id;
    private LocalDateTime fechaReasignacion;
    private String motivo;
    private String observacion;
    private Captacion captacion;
    private AgenteInmobiliario agenteAnterior;
    private AgenteInmobiliario agenteNuevo;
    private Broker brokerAutorizador;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getFechaReasignacion() {
        return fechaReasignacion;
    }

    public void setFechaReasignacion(LocalDateTime fechaReasignacion) {
        this.fechaReasignacion = fechaReasignacion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Captacion getCaptacion() {
        return captacion;
    }

    public void setCaptacion(Captacion captacion) {
        this.captacion = captacion;
    }

    public AgenteInmobiliario getAgenteAnterior() {
        return agenteAnterior;
    }

    public void setAgenteAnterior(AgenteInmobiliario agenteAnterior) {
        this.agenteAnterior = agenteAnterior;
    }

    public AgenteInmobiliario getAgenteNuevo() {
        return agenteNuevo;
    }

    public void setAgenteNuevo(AgenteInmobiliario agenteNuevo) {
        this.agenteNuevo = agenteNuevo;
    }

    public Broker getBrokerAutorizador() {
        return brokerAutorizador;
    }

    public void setBrokerAutorizador(Broker brokerAutorizador) {
        this.brokerAutorizador = brokerAutorizador;
    }
}


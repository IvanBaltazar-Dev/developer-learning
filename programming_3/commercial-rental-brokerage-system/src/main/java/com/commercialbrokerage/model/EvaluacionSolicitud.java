package com.commercialbrokerage.model;

import java.time.LocalDateTime;

public class EvaluacionSolicitud {

    private long id;
    private LocalDateTime fechaEvaluacion;
    private String resultado;
    private String comentario;
    private SolicitudAlquiler solicitudAlquiler;
    private UsuarioInterno responsableEvaluacion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDateTime fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public SolicitudAlquiler getSolicitudAlquiler() {
        return solicitudAlquiler;
    }

    public void setSolicitudAlquiler(SolicitudAlquiler solicitudAlquiler) {
        this.solicitudAlquiler = solicitudAlquiler;
    }

    public UsuarioInterno getResponsableEvaluacion() {
        return responsableEvaluacion;
    }

    public void setResponsableEvaluacion(UsuarioInterno responsableEvaluacion) {
        this.responsableEvaluacion = responsableEvaluacion;
    }
}


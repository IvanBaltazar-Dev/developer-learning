package com.commercialbrokerage.model;

import java.util.ArrayList;
import java.util.List;

public class Broker extends UsuarioInterno {

    private String codigoBroker;
    private List<Captacion> captacionesSupervisadas = new ArrayList<>();
    private List<ReasignacionCaptacion> reasignacionesAutorizadas = new ArrayList<>();

    public String getCodigoBroker() {
        return codigoBroker;
    }

    public void setCodigoBroker(String codigoBroker) {
        this.codigoBroker = codigoBroker;
    }

    public List<Captacion> getCaptacionesSupervisadas() {
        return captacionesSupervisadas;
    }

    public void setCaptacionesSupervisadas(List<Captacion> captacionesSupervisadas) {
        this.captacionesSupervisadas = captacionesSupervisadas;
    }

    public List<ReasignacionCaptacion> getReasignacionesAutorizadas() {
        return reasignacionesAutorizadas;
    }

    public void setReasignacionesAutorizadas(List<ReasignacionCaptacion> reasignacionesAutorizadas) {
        this.reasignacionesAutorizadas = reasignacionesAutorizadas;
    }
}


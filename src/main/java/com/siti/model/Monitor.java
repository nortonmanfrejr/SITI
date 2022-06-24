package com.siti.model;

import com.siti.view.MonitorHUD;

public class Monitor extends MonitorHUD {

    //#region atributos

    public Long id;
    public Integer patrimonio;
    public String servicetag;
    public String marca;
    public String modelo;
    public String departamento;
    public String setor;
    public String ajustavel;
    public String andar;
    public String observacao;
    //endregion

    //#region construtor

    public Monitor(Long id,
                   Integer patrimonio,
                   String servicetag,
                   String marca,
                   String modelo,
                   String departamento,
                   String setor,
                   String ajustavel,
                   String andar,
                   String observacao){
        this.id = id;
        this.patrimonio = patrimonio;
        this.servicetag = servicetag;
        this.marca = marca;
        this.modelo = modelo;
        this.departamento = departamento;
        this.setor = setor;
        this.ajustavel = ajustavel;
        this.andar = andar;
        this.observacao = observacao;

    }
    //endregion

    //#region getters && setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(Integer patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getServicetag() {
        return servicetag;
    }

    public void setServicetag(String servicetag) {
        this.servicetag = servicetag;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getAjustavel() {
        return ajustavel;
    }

    public void setAjustavel(String ajustavel) {
        this.ajustavel = ajustavel;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    //endregion

}

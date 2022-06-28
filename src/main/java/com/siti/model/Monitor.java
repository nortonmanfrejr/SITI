package com.siti.model;

import com.siti.view.HMonitor;

public class Monitor extends HMonitor {

    //#region atributos

    public Integer id;
    public String patrimonio;
    public String servicetag;
    public String marca;
    public String modelo;
    public String departamento;
    public String setor;
    public String ajustavel;
    public String andar;
    public String observacao;
    public String tipo;
    public String estado;
    //endregion

    //#region construtor

    public Monitor(Integer id,
                   String patrimonio,
                   String servicetag,
                   String marca,
                   String modelo,
                   String departamento,
                   String setor,
                   String ajustavel,
                   String andar,
                   String observacao,
                   String tipo,
                   String estado){
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
        this.tipo = tipo;
        this.estado = estado;

    }

    public Monitor(String patrimonio,
                   String servicetag,
                   String marca,
                   String modelo,
                   String departamento,
                   String setor,
                   String ajustavel,
                   String andar,
                   String observacao,
                   String tipo,
                   String estado){
        this.patrimonio = patrimonio;
        this.servicetag = servicetag;
        this.marca = marca;
        this.modelo = modelo;
        this.departamento = departamento;
        this.setor = setor;
        this.ajustavel = ajustavel;
        this.andar = andar;
        this.observacao = observacao;
        this.tipo = tipo;
        this.estado = estado;

    }

    public Monitor() {
        super();
    }
    //endregion

    //#region getters && setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //endregion

    //#region toString

    @Override
    public String toString() {
        return "Monitor{" +
                "id=" + id +
                ", patrimonio=" + patrimonio +
                ", servicetag='" + servicetag + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", departamento='" + departamento + '\'' +
                ", setor='" + setor + '\'' +
                ", ajustavel='" + ajustavel + '\'' +
                ", andar='" + andar + '\'' +
                ", observacao='" + observacao + '\'' +
                ", tipo='" + tipo + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
    //endregion



}

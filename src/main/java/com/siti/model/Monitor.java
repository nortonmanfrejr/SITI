package com.siti.model;

public class Monitor {


    //#region Atributos
    protected Integer id;
    protected String patrimonio;
    protected String serviceTag;
    protected String marca;
    protected String modelo;
    protected String andar;
    protected String departamento;
    protected String setor;
    protected String status;
    //endregion

    //#region Construtor
    public Monitor(Integer id,
                   String patrimonio,
                   String serviceTag,
                   String marca,
                   String modelo,
                   String andar,
                   String departamento,
                   String setor,
                   String status){
        this.id = id;
        this.patrimonio = patrimonio;
        this.serviceTag = serviceTag;
        this.marca = marca;
        this.modelo = modelo;
        this.andar = andar;
        this.departamento = departamento;
        this.setor = setor;
        this.status = status;
    }
    //endregion

    //#region Getters && Setters
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

    public String getServiceTag() {
        return serviceTag;
    }

    public void setServiceTag(String serviceTag) {
        this.serviceTag = serviceTag;
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

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //endregion
}

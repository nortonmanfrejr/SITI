package com.siti.model;

public class Equipamento {

    //#region Atributos Maquina
    protected Integer id;
    protected String patrimonio;
    protected String monitor1;
    protected String monitor2;
    protected String serviceTag;
    protected String marca;
    protected String modelo;
    protected String andar;
    protected String tipo;
    protected String departamento;
    protected String setor;
    protected String obs;
    protected String status;
    //endregion

    //#region Construtor
    public Equipamento(Integer id,
                       String patrimonio,
                       String monitor1,
                       String monitor2,
                       String serviceTag,
                       String marca,
                       String modelo,
                       String andar,
                       String tipo,
                       String departamento,
                       String setor,
                       String obs,
                       String status){
        this.id = id;
        this.patrimonio = patrimonio;
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.serviceTag = serviceTag;
        this.marca = marca;
        this.modelo = modelo;
        this.andar = andar;
        this.tipo = tipo;
        this.departamento = departamento;
        this.setor = setor;
        this.obs = obs;
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

    public String getMonitor1() {
        return monitor1;
    }

    public void setMonitor1(String monitor1) {
        this.monitor1 = monitor1;
    }

    public String getMonitor2() {
        return monitor2;
    }

    public void setMonitor2(String monitor2) {
        this.monitor2 = monitor2;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //endregion

}

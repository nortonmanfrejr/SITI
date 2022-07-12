package com.siti.model;

import com.siti.view.HComputer;

public class Maquina extends HComputer {

    private Integer id;
    private String patrimonio;
    private String servicetag;
    private String marca;
    private String modelo;
    private String armazenamento;
    private String processador;
    private String memoriaRAM;
    private String sistemaOperacional;
    private String departamento;
    private String setor;
    private String andar;
    private String observacao;
    private String tipo;
    private String estado;

    //#region construtores
    public Maquina(Integer id,
                   String patrimonio,
                   String servicetag,
                   String marca,
                   String modelo,
                   String armazenamento,
                   String processador,
                   String memoriaRAM,
                   String sistemaOperacional,
                   String departamento,
                   String setor,
                   String andar,
                   String observacao,
                   String tipo,
                   String estado){
        this.id = id;
        this.patrimonio = patrimonio;
        this.servicetag = servicetag;
        this.marca = marca;
        this.modelo = modelo;
        this.armazenamento = armazenamento;
        this.processador = processador;
        this.memoriaRAM = memoriaRAM;
        this.sistemaOperacional = sistemaOperacional;
        this.departamento = departamento;
        this.setor = setor;
        this.andar = andar;
        this.observacao = observacao;
        this.tipo = tipo;
        this.estado = estado;
    }


    public Maquina(String patrimonio,
                   String servicetag,
                   String marca,
                   String modelo,
                   String armazenamento,
                   String processador,
                   String memoriaRAM,
                   String sistemaOperacional,
                   String departamento,
                   String setor,
                   String andar,
                   String observacao,
                   String tipo,
                   String estado){
        this.patrimonio = patrimonio;
        this.servicetag = servicetag;
        this.marca = marca;
        this.modelo = modelo;
        this.armazenamento = armazenamento;
        this.processador = processador;
        this.memoriaRAM = memoriaRAM;
        this.sistemaOperacional = sistemaOperacional;
        this.departamento = departamento;
        this.setor = setor;
        this.andar = andar;
        this.observacao = observacao;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Maquina() {
        super();
    }

    //endregion

    //#region getters e setters
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

    public String getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(String armazenamento) {
        this.armazenamento = armazenamento;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setMemoriaRAM(String memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
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
        return "Maquina{" +
                "id=" + id +
                ", patrimonio='" + patrimonio + '\'' +
                ", servicetag='" + servicetag + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", armazenamento='" + armazenamento + '\'' +
                ", processador='" + processador + '\'' +
                ", memoriaRAM='" + memoriaRAM + '\'' +
                ", sistemaOperacional='" + sistemaOperacional + '\'' +
                ", departamento='" + departamento + '\'' +
                ", setor='" + setor + '\'' +
                ", andar='" + andar + '\'' +
                ", observacao='" + observacao + '\'' +
                ", tipo='" + tipo + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
    //endregion
}

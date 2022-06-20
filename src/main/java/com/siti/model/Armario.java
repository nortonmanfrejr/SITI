package com.siti.model;

public class Armario {


    //#region Atributos
    protected Integer id;
    protected String descricao;
    protected int quantidade;
    protected String andar;
    protected String departamento;
    protected String status;
    //endregion

    //#region Construtor
    public Armario(Integer id,
                   String descricao,
                   int quantidade,
                   String andar,
                   String departamento,
                   String status){
        this.id = id;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.andar = andar;
        this.departamento = departamento;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //endregion
}

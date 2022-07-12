package com.siti.model;

public class Armario {

    private Integer id;
    private String item;
    private String descricao;
    private String estado;

    public Armario(Integer id,
                   String item,
                   String descricao,
                   String estado){
        this.id = id;
        this.item = item;
        this.descricao = descricao;
        this.estado = estado;
    }

    public Armario(String item,
                   String descricao,
                   String estado){
        this.item = item;
        this.descricao = descricao;
        this.estado = estado;
    }

    public Armario(){
        super();
    }
    //#region getters e setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //endregion


    @Override
    public String toString() {
        return "Armario{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", descricao='" + descricao + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}

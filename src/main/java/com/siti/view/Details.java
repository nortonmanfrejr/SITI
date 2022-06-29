package com.siti.view;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Details {

    //#region Monitor Details

    public static Label lblTipo, lblPatrimonio, lblServicetag,
            lblAndar, lblDepartamento, lblSetor,
            lblMarca, lblModelo, lblObs, lblStatus;

    /**
     * @return box de detalhes dos itens, é um suporte para o callback tambem.
     * */
    protected static VBox detalhe(){

        lblTipo = new Label("Tipo: ");
        lblPatrimonio = new Label("Patrimonio: ");
        lblServicetag = new Label("Service Tag: ");
        lblAndar = new Label("Andar: ");
        lblDepartamento = new Label("Departamento: ");
        lblSetor = new Label("Setor: ");
        lblMarca = new Label("Marca: ");
        lblModelo = new Label("Modelo: ");
        lblObs = new Label("Observação: ");
        lblStatus = new Label("Status: ");

        VBox box = new VBox(10);
        box.getChildren().addAll(
                lblTipo,
                lblPatrimonio,
                lblServicetag,
                lblAndar,
                lblDepartamento,
                lblSetor,
                lblMarca,
                lblModelo,
                lblStatus,
                lblObs);

        return box;
    }
    //endregion

}

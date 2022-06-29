package com.siti.view;

import com.siti.dao.DMonitor;
import com.siti.repository.MonitorRepository;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Buttons {



    /**
     * @return uma caixa contendo os botões de criar, ler, alterar e deletar.
     * */
    protected static VBox buttonBox(){

        VBox box = new VBox(10);
        box.getChildren().addAll(create(),read(),update(),delete());

        return box;
    }

    /**
     * @return create data button.
     * */
    private static Button create() {
        Button b = new Button("Create...");
        b.setPrefWidth(100);
        b.setOnAction(e -> {
            DMonitor.createMonitor();
            DMonitor.obterMonitor();
        });

        return b;
    }
    /**
     * @return read data button.
     * */
    private static Button read() {
        Button b = new Button("Read...");
        b.setPrefWidth(100);
        b.setOnAction( e -> {


            System.out.println(MonitorRepository.obterUnico(HMonitor.txfBuscar.getText()));
//            Informations.monitorTable().setItems(MonitorRepository.obterUnico(identificador));

        });

        return b;
    }
    /**
     * @return update data button.
     * */
    private static Button update(){
        Button b = new Button("Update...");
        b.setPrefWidth(100);
        return b;
    }

    /**
     * @return delete data button.
     * */
    private static Button delete(){
        Button b = new Button("Delete...");
        b.setPrefWidth(100);
        return b;
    }

    /**
     * @return one archive xls.
     * */
    protected static Button xlsExport(){
        Button b  = new Button("Export to XLS...");
        b.setPrefWidth(100);
        return b;
    }

    protected static Button buscar(){
        Button b = new Button("Buscar...");
        b.setPrefWidth(100);
        b.setOnAction(e -> {

        });
        return b;
    }

}

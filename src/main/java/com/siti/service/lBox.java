package com.siti.service;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class lBox {

    /**
     * @return create data button.
     * */
    private static Button create(){
        Button b = new Button("Create");

        b.setPrefHeight(30);
        b.setPrefWidth(100);

        return b;
    }

    /**
     * @return delete data button.
     * */
    private static Button delete(){
        Button b = new Button("Delete");

        b.setPrefHeight(30);
        b.setPrefWidth(100);

        return b;
    }

    /**
     * @return update data button.
     * */
    private static Button update(){
        Button b = new Button("Update");

        b.setPrefHeight(30);
        b.setPrefWidth(100);

        return b;
    }

    /**
     * @return search data button.
     * */
    private static Button search(){
        Button b = new Button("Search");

        b.setPrefHeight(30);
        b.setPrefWidth(100);

        return b;
    }

    public static ComboBox<String> tipo(){
        ComboBox<String> cb = new ComboBox<>();


        cb.setPrefHeight(30);
        cb.setPrefWidth(100);
        cb.setPromptText("Item");
        cb.getItems().addAll("Conjunto","Monitor","Computador","Ferramenta");

//        cb.getSelectionModel().selectedItemProperty().addListener((options,oldValue,newValue) -> {
//        });

        return cb;
    }

    static Separator vertical = new Separator(Orientation.VERTICAL);
    static Separator horizontal = new Separator(Orientation.HORIZONTAL);
    /**
     * @return left box of borderpane
     * */
    public static HBox leftBox(){
        /**
         * Insert the buttons into box1 and insert box1 into box with a separator.
         * the separator is just to make the layout beautiful.
         * */
        VBox box1 = new VBox();
        box1.getChildren().
                addAll(create(),
                        update(),
                        search(),
                        delete(),
                        horizontal,
                        tipo()
                );

        HBox box = new HBox();
        box.getChildren().addAll(box1,vertical);

        return box;
    }

}

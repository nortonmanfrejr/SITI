package com.siti.repository;


import com.siti.dao.DMonitor;
import com.siti.model.Monitor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Optional;

public class MonitorRepository {

    /**
     * Retorna uma lista de monitores atraves de uma String, caso não seja uma String ele retorna um ID.
     * @return lista de monitores.
     * */
    public static ObservableList<Monitor> obterTodos(){
        return DMonitor.obterMonitor();
    }

    public static Optional<Monitor> obterUnico(String identificador){

        ObservableList<Monitor> monitors = FXCollections.observableArrayList(DMonitor.obterMonitor());


        return monitors.stream()
                .filter(monitor -> monitor.getServicetag() == identificador || monitor.getPatrimonio() == identificador)
                .findFirst();


    }

}

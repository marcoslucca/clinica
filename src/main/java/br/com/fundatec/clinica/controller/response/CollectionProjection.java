package br.com.fundatec.clinica.controller.response;

import java.util.List;

public class CollectionProjection {
    private List<ConsultaProjection> items;

    public CollectionProjection(List<ConsultaProjection> items) {
        this.items = items;
    }

    public CollectionProjection() {
    }

    public List<ConsultaProjection> getItems() {
        return items;
    }

    public void setItems(List<ConsultaProjection> items) {
        this.items = items;
    }
}

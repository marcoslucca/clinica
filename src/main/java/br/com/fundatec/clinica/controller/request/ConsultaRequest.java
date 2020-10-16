package br.com.fundatec.clinica.controller.request;

public class ConsultaRequest {

    private String vet;
    private String date;

    public String getVet() {
        return vet;
    }

    public void setVet(String vet) {
        this.vet = vet;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

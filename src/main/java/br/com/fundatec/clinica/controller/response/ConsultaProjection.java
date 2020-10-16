package br.com.fundatec.clinica.controller.response;

import br.com.fundatec.clinica.domain.Consulta;

public class ConsultaProjection {
    private Long id;
    private String vetName;
    private String date;

    public ConsultaProjection(Long id, String vetName, String date) {
        this.id = id;
        this.vetName = vetName;
        this.date = date;
    }

    public ConsultaProjection() {
    }

    public static ConsultaProjection create(Consulta consulta) {
        return new ConsultaProjection(
            consulta.getId(),
            consulta.getNomeVeterinario(),
            consulta.getData().toString()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVetName() {
        return vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

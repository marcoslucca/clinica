package br.com.fundatec.clinica.controller;

import br.com.fundatec.clinica.controller.request.ConsultaRequest;
import br.com.fundatec.clinica.controller.response.CollectionProjection;
import br.com.fundatec.clinica.controller.response.ConsultaProjection;
import br.com.fundatec.clinica.domain.Consulta;
import br.com.fundatec.clinica.service.ConsultaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clinica/consultas")
public class ClinicaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<CollectionProjection> findAllConsulta() {
        List<Consulta> resultado = consultaService.findAllConsulta();

        return new ResponseEntity<>(convertToProjection(resultado), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaProjection> findById(@PathVariable Long id) {
        Consulta consulta = consultaService.findById(id);

        ConsultaProjection consultaProjection = ConsultaProjection.create(consulta);

        return new ResponseEntity<>(consultaProjection, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsultaProjection> cadastraConsulta(@RequestBody ConsultaRequest request) {
        Consulta consultaSalva = consultaService.salva(request);

        return new ResponseEntity<>(ConsultaProjection.create(consultaSalva), HttpStatus.OK);
    }

    private CollectionProjection convertToProjection(List<Consulta> consultas) {
        List<ConsultaProjection> resultado = new ArrayList<>();

        for (Consulta consulta : consultas) {
            resultado.add(ConsultaProjection.create(consulta));
        }

        return new CollectionProjection(resultado);
    }

}

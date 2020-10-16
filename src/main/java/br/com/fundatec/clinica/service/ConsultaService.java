package br.com.fundatec.clinica.service;

import br.com.fundatec.clinica.controller.request.ConsultaRequest;
import br.com.fundatec.clinica.controller.response.CollectionProjection;
import br.com.fundatec.clinica.controller.response.ConsultaProjection;
import br.com.fundatec.clinica.domain.Consulta;
import br.com.fundatec.clinica.exception.InvalidDateException;
import br.com.fundatec.clinica.exception.NotFoundException;
import br.com.fundatec.clinica.repository.ConsultaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> findAllConsulta() {
        return consultaRepository.findAll();
    }

    public Consulta salva(ConsultaRequest consultaRequest) {
        LocalDate data;

        try {
            data = LocalDate.parse(consultaRequest.getDate());
        } catch (Exception e) {
            throw new InvalidDateException(e.getLocalizedMessage());
        }

        Consulta consulta = new Consulta(consultaRequest.getVet(), data);

        return consultaRepository.saveAndFlush(consulta);
    }

    public Consulta findById(Long id) {
        Optional<Consulta> resultado = consultaRepository.findById(id);

        if(resultado.isEmpty()) {
            throw new NotFoundException("A consulta não foi encontrada");
        }

        return resultado.get();
    }
}

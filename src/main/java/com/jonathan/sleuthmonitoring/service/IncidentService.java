package com.jonathan.sleuthmonitoring.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class IncidentService {

    public void processIncident() {
        log.info("recebendo a criacao do chamado");
        log.info("encaminhando seu chamado para o setor responsavel");
    }
}

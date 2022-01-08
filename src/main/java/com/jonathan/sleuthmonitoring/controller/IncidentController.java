package com.jonathan.sleuthmonitoring.controller;

import com.jonathan.sleuthmonitoring.model.Incident;
import com.jonathan.sleuthmonitoring.repository.IncidentRepository;
import com.jonathan.sleuthmonitoring.service.IncidentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/v1")
@Log4j2
public class IncidentController {

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private IncidentService service;

    @PostMapping("/incidents")
    public ResponseEntity<Incident> createIncident(@Valid @RequestBody Incident incident) {
        log.info("Criando um incidente com o nome {} e a descricao {}",
                incident.getName(), incident.getDescription());
        service.processIncident();
        ResponseEntity<Incident> reponse = ResponseEntity.ok(incidentRepository.save(incident));
        return reponse;
    }

    @GetMapping("/incidents")
    public ResponseEntity<List<Incident>> getAllIncidents() {
        log.info("Listando todos os incidentes cadastrados");
        return ResponseEntity.ok(incidentRepository.findAll());
    }
}

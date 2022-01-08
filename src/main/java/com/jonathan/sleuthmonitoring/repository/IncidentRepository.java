package com.jonathan.sleuthmonitoring.repository;

import com.jonathan.sleuthmonitoring.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {
}

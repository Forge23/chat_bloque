package edu.itq.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.itq.soa.dto.Ficha;
import edu.itq.soa.dto.Empleados;

public interface EmpleadosRepository extends JpaRepository<Empleados, Integer> {

}

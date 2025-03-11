package edu.itq.soa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.itq.soa.dto.Empleados;
import edu.itq.soa.repository.EmpleadosRepository;

/**
 * Servicio para manejar empleados.
 */
@Service
public class EmployeeService {
    
    @Autowired
    private EmpleadosRepository empleadosRepository;

    /**
     * Consulta todos los empleados registrados.
     * @return Lista de empleados.
     */
    public List<Empleados> getEmpleados() {
        return empleadosRepository.findAll();
    }
}

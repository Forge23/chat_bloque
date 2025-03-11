package edu.itq.soa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.itq.soa.dto.Empleados;
import edu.itq.soa.service.EmployeeService;

/**
 * Controlador REST para empleados.
 */
@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*") // Permitir acceso desde el frontend
public class EmpleadosRest {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Obtiene todos los empleados.
     * @return Lista de empleados.
     */
    @GetMapping
    public List<Empleados> getEmpleados() {
        return employeeService.getEmpleados();
    }
}

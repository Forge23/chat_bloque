package edu.itq.soa.dto;

import com.google.gson.Gson;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO para las peticiones recibidas.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleados { // usuario_streaming
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_empleados;
    
//    @Column(name ="login")
    private String nombre;

//    @Column(name ="password")
    private String apellidos;
    
    private String password;

    /** Representación en formato JSON del objeto actual. */
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}

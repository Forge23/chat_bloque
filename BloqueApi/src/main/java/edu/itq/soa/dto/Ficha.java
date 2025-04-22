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
@Table(name = "ficha")
public class Ficha { // usuario_streaming
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
//    @Column(name ="login")
    private String nombre;

//    @Column(name ="password")
    private String telefono;
    
    private String mail;
    
    private String empresa;
    
    private String folio;
    
    private String fecha;
    
    private String aforo;
    
    private int token;
    
    private int estatus;

    /** Representación en formato JSON del objeto actual. */
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}

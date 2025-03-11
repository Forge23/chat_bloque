/**
 * 
 */
package edu.itq.soa.rest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.itq.soa.dto.Ficha;
import edu.itq.soa.service.FichaService;

/**
 * 
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ficha")
public class FichaRest {

    @Autowired
    private FichaService usuarioService;

//    @RequestMapping(method = RequestMethod.POST)
    @GetMapping
    public List<Ficha> getUsers() {
        return usuarioService.getUsuarios();
    }
    @GetMapping("/fichas")
    public ResponseEntity<List<Ficha>> getAllFichas() {
        List<Ficha> fichas = usuarioService.getUsuarios();
        return ResponseEntity.ok().body(fichas);
    }

    @PostMapping("/crear")
    public Ficha crearUsuario(@RequestBody Ficha usuario) {
    	usuarioService.createUsuario(usuario);
        return usuario;
    }
    
    // Clase auxiliar para mapear el JSON
    static class TokenRequest {
        private Integer nuevoToken;

        public Integer getNuevoToken() {
            return nuevoToken;
        }

        public void setNuevoToken(Integer nuevoToken) {
            this.nuevoToken = nuevoToken;
        }
    }

    @PutMapping("/token/{folio}")
    public ResponseEntity<Ficha> actualizarToken(@PathVariable String folio, @RequestBody TokenRequest request) {
        Optional<Ficha> fichaActualizada = usuarioService.updateTokenByFolio(folio, request.getNuevoToken());

        return fichaActualizada.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) {
        usuarioService.readUsuarioById(id).ifPresent(u -> {
            usuarioService.deleteUsuario(u);
        });
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/buscar/{folio}")
    public Optional<Ficha> buscarPorFolio(@PathVariable String folio) {
        return usuarioService.readUsuarioByFolio(folio);
    }
    
    @PutMapping("/estatus/{id}")
    public ResponseEntity<?> updateEstatus(@PathVariable Integer id, @RequestBody Map<String, String> request) {
        try {
            Integer nuevoEstatus = Integer.parseInt(request.get("estatus"));
            Ficha fichaActualizada = usuarioService.updateEstatusById(id, nuevoEstatus);
            return ResponseEntity.ok(fichaActualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }


}

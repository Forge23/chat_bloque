/**
 * 
 */
package edu.itq.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.itq.soa.dto.Ficha;
import edu.itq.soa.repository.FichaRepository;

/**
 * Capa de negocio para los usuarios.
 */
@Service
public class FichaService {
    @Autowired
    FichaRepository usuarioRepository;
    
    
    /**
     *Consulta de usuarios 
     * @return
     */
    public List<Ficha> getUsuarios() {
        return usuarioRepository.findAll();
    }
    
    /**
     * Creacion de Usuario
     */
    
    public Ficha createUsuario(Ficha usuario) {
    	return usuarioRepository.save(usuario);
    }
    
    /**
     * Consulta todos los usuarios registrados.
     * @return Lista de usuarios.
     */
    public Optional<Ficha> readUsuarioById(Integer id) {
        return usuarioRepository.findById(id);
    }
    
    /**
     * Borra un usuario.
     * @param usuario Usuario a borrar.
     */
    public void deleteUsuario(Ficha usuario) {
        usuarioRepository.delete(usuario);
    }
    
    /**
     * Consulta un usuario por su folio.
     * @param folio Número de folio.
     * @return Usuario con el folio dado.
     */
    public Optional<Ficha> readUsuarioByFolio(String folio) {
        return usuarioRepository.findByFolio(folio);
    }
    
    /**
     * Modifica el token de una ficha según el folio.
     * @param folio Identificador de la ficha.
     * @param nuevoToken Nuevo valor del token.
     * @return La ficha actualizada o un Optional vacío si no se encontró.
     */
    public Optional<Ficha> updateTokenByFolio(String folio, Integer nuevoToken) {
        Optional<Ficha> fichaOpt = usuarioRepository.findByFolio(folio);

        if (fichaOpt.isPresent()) {
            Ficha ficha = fichaOpt.get();
            ficha.setToken(nuevoToken);
            return Optional.of(usuarioRepository.save(ficha));
        } else {
            return Optional.empty();
        }
    }
    
    /**
     * Actualiza el estatus de una ficha por su ID.
     */
    public Ficha updateEstatusById(Integer id, Integer nuevoEstatus) {
        Optional<Ficha> fichaOpt = usuarioRepository.findById(id);
        if (fichaOpt.isPresent()) {
            Ficha ficha = fichaOpt.get();
            ficha.setEstatus(nuevoEstatus); // Actualiza el estatus
            return usuarioRepository.save(ficha); // Guarda los cambios
        }
        throw new RuntimeException("Ficha no encontrada con ID: " + id);
    }

}

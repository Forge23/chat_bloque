package edu.itq.soa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.itq.soa.dto.Ficha;

public interface FichaRepository extends JpaRepository<Ficha, Integer> {
	 Optional<Ficha> findByFolio(String folio); // Busca por folio
}

package pe.company.pmmcourier.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.company.pmmcourier.model.ERole;
import pe.company.pmmcourier.model.TipoColaborador;

@Repository
public interface RoleRepository extends JpaRepository<TipoColaborador, Integer> {
	Optional<TipoColaborador> findByName(ERole tipocolaborador);
}

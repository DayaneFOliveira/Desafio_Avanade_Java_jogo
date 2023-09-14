package desafio.avanade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import desafio.avanade.model.Batalha;

@Repository
public interface BatalhaRepository extends JpaRepository<Batalha, Long> {
    List<Batalha> findByIdInicio(Long eventoId);
}

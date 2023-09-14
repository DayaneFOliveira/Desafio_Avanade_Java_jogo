package desafio.avanade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import desafio.avanade.model.HistoricoBatalha;

@Repository
public interface HistoricoBatalhaRepository extends JpaRepository<HistoricoBatalha, Long> {
} 
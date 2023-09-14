package desafio.avanade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import desafio.avanade.model.Iniciativa;

@Repository
public interface IniciativaRepository extends JpaRepository<Iniciativa, Long> {
}

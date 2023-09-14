package desafio.avanade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import desafio.avanade.model.Heroi;

@Repository
public interface HeroiRepository extends JpaRepository<Heroi, Long> {
    List<Heroi> findByVida(int i);
}
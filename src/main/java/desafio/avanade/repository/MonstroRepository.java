package desafio.avanade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import desafio.avanade.model.Monstro;

@Repository
public interface MonstroRepository extends JpaRepository<Monstro, Long> {
    List<Monstro> findByVida(int i);
}

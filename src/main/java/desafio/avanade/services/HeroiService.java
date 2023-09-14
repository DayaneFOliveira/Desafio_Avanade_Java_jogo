package desafio.avanade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import desafio.avanade.model.Heroi;
import desafio.avanade.repository.HeroiRepository;
import java.util.List;
import java.util.Optional;

@Service
public class HeroiService {
    @Autowired
    private HeroiRepository heroiRepository;

    public List<Heroi> listarHerois() {
        return heroiRepository.findAll();
    }

    public Optional<Heroi> encontrarHeroiPorId(Long id) {
        return heroiRepository.findById(id);
    }

    public Heroi criarHeroi(Heroi heroi) {
        return heroiRepository.save(heroi);
    }

    public Heroi atualizarHeroi(Long id, Heroi heroi) {
        if (heroiRepository.existsById(id)) {
            heroi.setId(id);
            return heroiRepository.save(heroi);
        }
        return null; // Herói não encontrado
    }

    public void deletarHeroi(Long id) {
        heroiRepository.deleteById(id);
    }
}


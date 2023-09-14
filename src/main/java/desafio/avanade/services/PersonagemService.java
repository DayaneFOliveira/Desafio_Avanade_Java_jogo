package desafio.avanade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desafio.avanade.model.Personagem;
import desafio.avanade.repository.PersonagemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {
    @Autowired
    private PersonagemRepository personagemRepository;

    public List<Personagem> listarPersonagens() {
        return personagemRepository.findAll();
    }

    public Optional<Personagem> encontrarPersonagemPorId(Long id) {
        return personagemRepository.findById(id);
    }

    public Personagem criarPersonagem(Personagem personagem) {
        return personagemRepository.save(personagem);
    }

    public Personagem atualizarPersonagem(Long id, Personagem personagem) {
        if (personagemRepository.existsById(id)) {
            personagem.setId(id);
            return personagemRepository.save(personagem);
        }
        return null; // Personagem não encontrado
    }

    public void deletarPersonagem(Long id) {
        personagemRepository.deleteById(id);
    }
}

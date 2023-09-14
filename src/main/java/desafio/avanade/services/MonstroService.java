package desafio.avanade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desafio.avanade.model.Monstro;
import desafio.avanade.repository.MonstroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MonstroService {
    @Autowired
    private MonstroRepository monstroRepository;

    public List<Monstro> listarMonstros() {
        return monstroRepository.findAll();
    }

    public Optional<Monstro> encontrarMonstroPorId(Long id) {
        return monstroRepository.findById(id);
    }

    public Monstro criarMonstro(Monstro monstro) {
        return monstroRepository.save(monstro);
    }

    public Monstro atualizarMonstro(Long id, Monstro monstro) {
        if (monstroRepository.existsById(id)) {
            monstro.setId(id);
            return monstroRepository.save(monstro);
        }
        return null; // Monstro não encontrado
    }

    public void deletarMonstro(Long id) {
        monstroRepository.deleteById(id);
    }
}

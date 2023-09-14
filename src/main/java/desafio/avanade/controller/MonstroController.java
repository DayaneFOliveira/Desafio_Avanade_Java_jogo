package desafio.avanade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import desafio.avanade.model.Monstro;
import desafio.avanade.services.MonstroService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avanade/monstro")
@CrossOrigin(value = "*")
public class MonstroController {
    @Autowired
    private MonstroService monstroService;
    @GetMapping("/pesquisar")
    public List<Monstro> listarMonstros() {
        return monstroService.listarMonstros();
    }
    @GetMapping("/encontrar{id}")
    public Optional<Monstro> encontrarMonstroPorId(@PathVariable Long id) {
        return monstroService.encontrarMonstroPorId(id);
    }
    @PostMapping("/criar")
    public Monstro criarMonstro(@RequestBody Monstro monstro) {
        return monstroService.criarMonstro(monstro);
    }
    @PutMapping("/atualizar{id}")
    public Monstro atualizarMonstro(@PathVariable Long id, @RequestBody Monstro monstro) {
        return monstroService.atualizarMonstro(id, monstro);
    }
    @DeleteMapping("/deletar{id}")
    public void deletarMonstro(@PathVariable Long id) {
        monstroService.deletarMonstro(id);
    }
}
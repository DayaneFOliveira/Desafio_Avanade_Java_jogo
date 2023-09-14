package desafio.avanade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import desafio.avanade.model.Personagem;
import desafio.avanade.services.PersonagemService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avanade/personagem")
@CrossOrigin(value = "*")
public class PersonagemController {
    @Autowired
    private PersonagemService personagemService;
    @GetMapping("/pesquisar")
    public List<Personagem> listarPersonagens() {
        return personagemService.listarPersonagens();
    }
    @GetMapping("/encontrar{id}")
    public Optional<Personagem> encontrarPersonagemPorId(@PathVariable Long id) {
        return personagemService.encontrarPersonagemPorId(id);
    }
    @PostMapping("/criar")
    public Personagem criarPersonagem(@RequestBody Personagem personagem) {
        return personagemService.criarPersonagem(personagem);
    }
    @PutMapping("/atualizar{id}")
    public Personagem atualizarPersonagem(@PathVariable Long id, @RequestBody Personagem personagem) {
        return personagemService.atualizarPersonagem(id, personagem);
    }
    @DeleteMapping("/deletar{id}")
    public void deletarPersonagem(@PathVariable Long id) {
        personagemService.deletarPersonagem(id);
    }
}


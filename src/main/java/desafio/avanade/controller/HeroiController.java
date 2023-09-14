package desafio.avanade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import desafio.avanade.model.Heroi;
import desafio.avanade.services.HeroiService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avanade/herois")
@CrossOrigin(value = "*")
public class HeroiController {
    @Autowired
    private HeroiService heroiService;

    @GetMapping("/pesquisar")
    public List<Heroi> listarHerois() {
        return heroiService.listarHerois();
    }

    @GetMapping("/encontrar{id}")
    public Optional<Heroi> encontrarHeroiPorId(@PathVariable Long id) {
        return heroiService.encontrarHeroiPorId(id);
    }

    @PostMapping("/criar")
    public Heroi criarHeroi(@RequestBody Heroi heroi) {
        return heroiService.criarHeroi(heroi);
    }

    @PutMapping("/atualizar{id}")
    public Heroi atualizarHeroi(@PathVariable Long id, @RequestBody Heroi heroi) {
        return heroiService.atualizarHeroi(id, heroi);
    }

    @DeleteMapping("/deletar{id}")
    public void deletarHeroi(@PathVariable Long id) {
        heroiService.deletarHeroi(id);
    }
}

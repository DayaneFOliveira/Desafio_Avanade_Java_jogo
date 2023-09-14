package desafio.avanade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import desafio.avanade.model.Batalha;
import desafio.avanade.model.HistoricoBatalha;
import desafio.avanade.model.Personagem;
import desafio.avanade.services.BatalhaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "avanade/batalha")
@CrossOrigin(value = "*")
public class BatalhaController {

    private final BatalhaService batalhaService;
    @Autowired
    public BatalhaController(BatalhaService batalhaService) {
        this.batalhaService = batalhaService;
    }
    @GetMapping("/iniciativa")
    @ApiOperation("Iniciativa para determinar quem começa o ataque")
    public ResponseEntity<String> determinarIniciativa() {
        boolean iniciativaHeroi = batalhaService.determinarIniciativa();
        String resultado = iniciativaHeroi ? "Herói tem a iniciativa" : "Monstro tem a iniciativa";
        return ResponseEntity.ok(resultado);
    }
    @PostMapping("/ataque")
    @ApiOperation("Inicia o ataque")
    public ResponseEntity<Integer> calcularAtaque(@RequestBody Personagem personagem) {
        int ataque = batalhaService.calcularAtaque(personagem.getForca(), personagem.getAgilidade());
        return ResponseEntity.ok(ataque);
    }
    @PostMapping("/defesa")
    @ApiOperation("Inicia a defesa")
    public ResponseEntity<Integer> calcularDefesa(@RequestBody Personagem personagem) {
        int defesa = batalhaService.calcularDefesa(personagem.getDefesa(), personagem.getAgilidade());
        return ResponseEntity.ok(defesa);
    }
    @PostMapping("/dano")
    @ApiOperation("Calcula o dano")
    public int calcularDano(
            @RequestParam("quantidadeDados") int quantidadeDados,
            @RequestParam("facesDado") int facesDado,
            @RequestParam("forca") int forca) {
        return batalhaService.calcularDano(quantidadeDados, facesDado, forca);
    }
    @PostMapping("/pontos-vida")
    @ApiOperation("Atualizar os pontos de vida")
    public int calcularPontosDeVida(
            @RequestParam("pontosVida") int pontosVida,
            @RequestParam("dano") int dano) {
        return batalhaService.atualizarPontosDeVida(pontosVida, dano);
    }
    @GetMapping("/batalha-terminada")
    @ApiOperation("Fim da batalha")   
    public ResponseEntity<Boolean> batalhaTerminada(@RequestParam int pontosVidaHeroi, @RequestParam int pontosVidaMonstro) {
        boolean terminada = batalhaService.batalhaTerminada(pontosVidaHeroi, pontosVidaMonstro);
        return ResponseEntity.ok(terminada);
    }
    @PostMapping("/realizar-turno")
    @ApiOperation("Realizar o truno de batalha")
    public HistoricoBatalha realizarTurno(@RequestBody Personagem heroi, @RequestBody Personagem monstro) {
    HistoricoBatalha historico = new HistoricoBatalha();
    batalhaService.realizarTurnoDeBatalha(heroi, monstro, historico);
         return historico;
    }
    @GetMapping("/historico/{idIniciativa}")
    @ApiOperation("Historico do combate entre o personagem e o monstro")
    public ResponseEntity<List<Batalha>> historico(@PathVariable(value = "idIniciativa") Long idIniciativa){
        return new ResponseEntity<>(batalhaService.historicoBatalha(idIniciativa) ,HttpStatus.OK);
    }
}

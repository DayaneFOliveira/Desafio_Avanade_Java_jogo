package desafio.avanade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desafio.avanade.model.Batalha;
import desafio.avanade.model.HistoricoBatalha;
import desafio.avanade.model.Personagem;
import desafio.avanade.repository.BatalhaRepository;

import java.util.List;
import java.util.Random;

@Service
public class BatalhaService {
    private final Random random = new Random();
    @Autowired
    private BatalhaRepository repository;

    public boolean determinarIniciativa() {
        int resultadoHeroi = rolarDadoDe20Faces();
        int resultadoMonstro = rolarDadoDe20Faces();

        return resultadoHeroi > resultadoMonstro;
    }
    public int rolarDadoDe20Faces() {
        return random.nextInt(20) + 1;
    }
    public int rolarDadoDe12Faces() {
        return random.nextInt(12) + 1;
    }
    public int calcularAtaque(int forca, int agilidade) {
        int dadoDe12Faces = rolarDadoDe12Faces();
        return forca + agilidade + dadoDe12Faces;
    }
    public int calcularDefesa(int defesa, int agilidade) {
        int dadoDe12Faces = rolarDadoDe12Faces();
        return defesa + agilidade + dadoDe12Faces;
    }
    public int calcularDano(int quantidadeDados, int facesDado, int forca) {
        int totalDano = 0;
        for (int i = 0; i < quantidadeDados; i++) {
            totalDano += rolarDado(facesDado);
        }
        return totalDano + forca;
    }
    private int rolarDado(int facesDado) {
        return 0;
    }
    public int atualizarPontosDeVida(int pontosVida, int dano) {
        int pontosVidaAtualizados = pontosVida - dano;
        return Math.max(pontosVidaAtualizados, 0);
    }
    public boolean batalhaTerminada(int pontosVidaHeroi, int pontosVidaMonstro) {
        return pontosVidaHeroi <= 0 || pontosVidaMonstro <= 0;
    }
    public void realizarTurnoDeBatalha(
            Personagem heroi,
            Personagem monstro,
            HistoricoBatalha historico) {

        boolean iniciativaHeroi = determinarIniciativa();
        int ataqueHeroi = calcularAtaque(heroi.getForca(), heroi.getAgilidade());
        int defesaHeroi = calcularDefesa(heroi.getDefesa(), heroi.getAgilidade());
        int ataqueMonstro = calcularAtaque(monstro.getForca(), monstro.getAgilidade());
        int defesaMonstro = calcularDefesa(monstro.getDefesa(), monstro.getAgilidade());
        historico.adicionarTurno(
            iniciativaHeroi,
            ataqueHeroi,
            defesaHeroi,
            ataqueMonstro,
            defesaMonstro
        );

        if (ataqueHeroi > defesaMonstro) {
            int danoHeroi = calcularDano(heroi.getQuantidadeDeDados(), heroi.getFacesDoDado(), heroi.getForca());
            monstro.setPontosVida(atualizarPontosDeVida(monstro.getPontosVida(), danoHeroi));
        }

        if (ataqueMonstro > defesaHeroi) {
            int danoMonstro = calcularDano(monstro.getQuantidadeDeDados(), monstro.getFacesDoDado(), monstro.getForca());
            heroi.setPontosVida(atualizarPontosDeVida(heroi.getPontosVida(), danoMonstro));
        }
    }
    public List<Batalha> historicoBatalha(Long eventoId){
    List<Batalha> historico = repository.findByIdInicio(eventoId);
        return historico;
    }
}

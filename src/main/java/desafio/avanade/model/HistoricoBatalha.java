package desafio.avanade.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HistoricoBatalha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idHeroi;
    private Long idMonstro;
    private boolean iniciativaHeroi;
    private int numeroTurno;
    private int dadoAtaque;
    private int dadoDefesa;
    private int danoCausado;
    private int pontosVidaHeroi;
    private int pontosVidaMonstro;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getIdHeroi() {
        return idHeroi;
    }
    public void setIdHeroi(Long idHeroi) {
        this.idHeroi = idHeroi;
    }
    public Long getIdMonstro() {
        return idMonstro;
    }
    public void setIdMonstro(Long idMonstro) {
        this.idMonstro = idMonstro;
    }
    public boolean isIniciativaHeroi() {
        return iniciativaHeroi;
    }
    public void setIniciativaHeroi(boolean iniciativaHeroi) {
        this.iniciativaHeroi = iniciativaHeroi;
    }
    public int getNumeroTurno() {
        return numeroTurno;
    }
    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }
    public int getDadoAtaque() {
        return dadoAtaque;
    }
    public void setDadoAtaque(int dadoAtaque) {
        this.dadoAtaque = dadoAtaque;
    }
    public int getDadoDefesa() {
        return dadoDefesa;
    }
    public void setDadoDefesa(int dadoDefesa) {
        this.dadoDefesa = dadoDefesa;
    }
    public int getDanoCausado() {
        return danoCausado;
    }
    public void setDanoCausado(int danoCausado) {
        this.danoCausado = danoCausado;
    }
    public int getPontosVidaHeroi() {
        return pontosVidaHeroi;
    }
    public void setPontosVidaHeroi(int pontosVidaHeroi) {
        this.pontosVidaHeroi = pontosVidaHeroi;
    }
    public int getPontosVidaMonstro() {
        return pontosVidaMonstro;
    }
    public void setPontosVidaMonstro(int pontosVidaMonstro) {
        this.pontosVidaMonstro = pontosVidaMonstro;
    }
    public void adicionarTurno(boolean iniciativaHeroi2, int ataqueHeroi, int defesaHeroi, int ataqueMonstro,
            int defesaMonstro) {
    }   
}


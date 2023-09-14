package desafio.avanade.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Personagem")
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "Ataque")
    private int idAtaque;
    @OneToOne
    @JoinColumn(name = "Defesa")
    private int idDefesa;
    @OneToOne
    @JoinColumn(name = "Nome")
    private String nome;
    @ManyToOne
    @JoinColumn(name = "Vida")
    private int vida;
    @ManyToOne
    @JoinColumn(name = "Forca")
    private int forca;
    @ManyToOne
    @JoinColumn(name = "defesa")
    private int defesa;
    @ManyToOne
    @JoinColumn(name = "Agilidade")
    private int agilidade;
    @ManyToOne
    @JoinColumn(name = "QTD_Dados")
    private int quantidadeDeDados;
    @ManyToOne
    @JoinColumn(name = "Faces_Do_Dado")
    private int facesDoDado;
    public int getPontosVida() {
        return 0;
    }
    public void setPontosVida(int atualizarPontosDeVida) {
    }
 }

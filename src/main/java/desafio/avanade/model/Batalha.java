package desafio.avanade.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@NamedQuery(name = "Luta.consultarTurnos",
        query = "SELECT l FROM Luta l "+"WHERE l.idInicio= :idInicio")
@Table(name = "Batalha")
public class Batalha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "Inicio")
    private Long idInicio;
    @OneToOne
    @JoinColumn(name = "Personagem")
    private Integer idPersonagem;
    @OneToOne
    @JoinColumn(name = "Monstro")
    private Integer idMonstro;
    @OneToOne
    @JoinColumn(name = "Heroi")
    private Integer idHeroi;
    @ManyToOne
    @JoinColumn(name = "Ataque")
    private Integer idAtaque;
    @ManyToOne
    @JoinColumn(name = "Defesa")
    private Integer idDefesa;
    @ManyToOne
    @JoinColumn(name = "Dano")
    private Integer Dano;
    @ManyToOne
    @JoinColumn(name = "Pontos_Vida")
    private Integer idVida;
    @ManyToOne
    @JoinColumn(name = "Fim")
    private Boolean fim;
}

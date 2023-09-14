package desafio.avanade.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Inicio")
public class Iniciativa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "Personagem")
    private Personagem personagem;
    @OneToOne
    @JoinColumn(name = "Heroi")
    private Heroi heroi;
    @OneToOne
    @JoinColumn(name = "Monstro")
    private Monstro monstro;
}


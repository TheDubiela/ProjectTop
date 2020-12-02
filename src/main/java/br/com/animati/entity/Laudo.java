package br.com.animati.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Laudo {

    @Id
    @GeneratedValue
    private long idLaudo;

    private String text;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "atendimento_id", nullable = false)
    private Atendimento atendimento;
}

package br.com.animati.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Medico {
    @Id
    @GeneratedValue// (strategy = GenerationType.AUTO)
    private long idMedico;

    private String nome;

    private String uf;

    private String cpf;
}

package br.com.animati.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.animati.entity.Atendimento;

@Repository
public interface AtendimentoDAO extends JpaRepository<Atendimento, Long>{

}

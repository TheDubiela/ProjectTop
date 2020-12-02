package br.com.animati.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.animati.entity.Paciente;

@Repository
public interface PacienteDAO extends JpaRepository<Paciente, Long>{



}

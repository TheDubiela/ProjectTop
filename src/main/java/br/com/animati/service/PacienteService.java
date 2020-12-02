package br.com.animati.service;

import java.util.List;
import java.util.Optional;

import br.com.animati.entity.Paciente;

public interface PacienteService {
	
	void add(Paciente p);
	
	List<Paciente> list();

	void delete(Paciente paciente);
	
	Optional<Paciente> findById(long idPaciente);

	void deleteById(Long idPaciente);
	
}

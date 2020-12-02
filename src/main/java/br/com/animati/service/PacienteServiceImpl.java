package br.com.animati.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.animati.dao.PacienteDAO;
import br.com.animati.entity.Paciente;

@Service
public class PacienteServiceImpl implements PacienteService {
	
	@Autowired
	private PacienteDAO dao;
	
	public void add(Paciente p) {
		dao.save(p);
	}

	public List<Paciente> list() {
		return dao.findAll();
	}

	@Override
	public void delete(Paciente paciente) {
		dao.delete(paciente);
		
	}

	@Override
	public Optional<Paciente> findById(long idPaciente) {
		return dao.findById(idPaciente);
	}

	@Override
	public void deleteById(Long idPaciente) {
		dao.deleteById(idPaciente);
	}

}

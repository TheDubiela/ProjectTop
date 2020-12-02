package br.com.animati.service;

import java.util.List;
import java.util.Optional;

import br.com.animati.entity.Atendimento;

public interface AtendimentoService {
	
	void add(Atendimento atendimento);
	
	List<Atendimento> list();
	
	void delete(Atendimento atendimento);
	
	Optional<Atendimento> findById(long idAtendimento);

	void deleteById(Long idAtendimento);

}

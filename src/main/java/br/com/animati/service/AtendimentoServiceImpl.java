package br.com.animati.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.animati.dao.AtendimentoDAO;
import br.com.animati.entity.Atendimento;

@Service
public class AtendimentoServiceImpl implements AtendimentoService {
	
	@Autowired
	private AtendimentoDAO dao;

	@Override
	public void add(Atendimento atendimento) {
		dao.save(atendimento);
	}

	@Override
	public List<Atendimento> list() {
		return dao.findAll();
	}

	@Override
	public void delete(Atendimento atendimento) {
		dao.delete(atendimento);
	}

	@Override
	public Optional<Atendimento> findById(long idAtendimento) {
		return dao.findById(idAtendimento);
	}

	@Override
	public void deleteById(Long idAtendimento) {
		dao.deleteById(idAtendimento);
	}

}

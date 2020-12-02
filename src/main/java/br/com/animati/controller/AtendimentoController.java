package br.com.animati.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.animati.entity.Atendimento;
import br.com.animati.service.AtendimentoService;

@RestController
public class AtendimentoController {
	
	@Autowired
	private AtendimentoService atendimentoService;
	
	@RequestMapping("/atendimentos")
	public List<Atendimento> list() {
		return atendimentoService.list();
	}
	
	@PostMapping("/atendimentos")
	public void save(@RequestBody Atendimento p) {
		atendimentoService.add(p);
	}

	@DeleteMapping("/atendimentos/{idAtendimento}")
	public void delete(@PathVariable long idAtendimento) {
		atendimentoService.deleteById(idAtendimento);
	}

	@RequestMapping("/atendimentos/{idAtendimento}")
	public Atendimento findById(@PathVariable long idAtendimento) {
		return atendimentoService.findById(idAtendimento).get();
	}

	@PutMapping("/atendimentos/{idAtendimento}")
	public void update(@PathVariable long idAtendimento, @RequestBody Atendimento newAtendimento) {
		Optional<Atendimento> oldAtendimento = atendimentoService.findById(idAtendimento);
		if (oldAtendimento.isPresent()) {
			Atendimento atendimento = oldAtendimento.get();
			atendimento.setDataHora(newAtendimento.getDataHora());
			atendimento.setNomeProcedimento(newAtendimento.getNomeProcedimento());
			atendimento.setPaciente(newAtendimento.getPaciente());
			atendimento.setMedico(newAtendimento.getMedico());
			atendimentoService.add(atendimento);
		}
	}

}

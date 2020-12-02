package br.com.animati;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.animati.entity.Paciente;
import br.com.animati.service.PacienteService;

@SpringBootTest
class PacienteTests {
	
	@Autowired
	private PacienteService pacienteService;

	void init() {
		Paciente p1 = new Paciente();
		p1.setNome("Andre Jobim");
		p1.setCpf("0020020002-22");
		
		pacienteService.add(p1);
		
		Paciente p2 = new Paciente();
		p2.setNome("Rafael Scheidt");
		p2.setCpf("0010010001-12");
		
		pacienteService.add(p2);
	}
	
	@Test
	void listTest() {
		init();
		List<Paciente> list = pacienteService.list();
		assertEquals(2, list.size());
	}
	
	@Test
	void deleteTest() {
		Paciente paciente = pacienteService.findById(1).get();
		pacienteService.delete(paciente);
		
		List<Paciente> list = pacienteService.list();
		assertEquals(1, list.size());
	}
	
	@Test
	void editTest() {
		Paciente paciente = pacienteService.findById(2).get();
		String nome = "Joao Silva";
		paciente.setNome(nome);
		pacienteService.add(paciente);
		
		paciente = pacienteService.findById(2).get();
		assertEquals(nome, paciente.getNome());
	}

}

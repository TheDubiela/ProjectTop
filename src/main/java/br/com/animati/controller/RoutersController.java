package br.com.animati.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutersController {
	
	@GetMapping("/paciente/index")
	public String pacienteIndex() {
	    return "/paciente/index";
	}

	@GetMapping("/atendimento/index")
	public String atendimentoIndex() {
		return "/atendimento/index";
	}

	@GetMapping("/medico/index")
	public String medicoIndex() {
		return "/medico/index";
	}

	@GetMapping("/laudo/index")
	public String laudoIndex(){
		return "/laudo/index";
	}

}

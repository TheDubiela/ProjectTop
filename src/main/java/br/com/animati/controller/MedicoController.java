package br.com.animati.controller;

import br.com.animati.entity.Medico;
import br.com.animati.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @RequestMapping("/medicos")
    public List<Medico> list(){
        return medicoService.list();
    }

    @PostMapping("/medicos")
    public void save(@RequestBody Medico m) {
        medicoService.add(m);
    }

    @DeleteMapping("/medicos/{idMedico}")
    public void delete(@PathVariable long idMedico) {
        medicoService.deleteById(idMedico);
    }

    @RequestMapping("/medicos/{idMedico}")
    public Medico findById(@PathVariable long idMedico) {
        return medicoService.findById(idMedico).get();
    }

    @PutMapping("/medicos/{idMedico}")
    public void update(@PathVariable long idMedico, @RequestBody Medico newMedico) {
        Optional<Medico> oldMedico = medicoService.findById(idMedico);
        if (oldMedico.isPresent()) {
            Medico medico = oldMedico.get();
            medico.setNome(newMedico.getNome());
            medico.setCpf(newMedico.getCpf());
            medico.setUf(newMedico.getUf());
            medicoService.add(medico);
        }
    }
}

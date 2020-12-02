package br.com.animati.controller;

import br.com.animati.entity.Laudo;
import br.com.animati.service.LaudoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaudoController {
    @Autowired
    private LaudoService laudoService;

    @RequestMapping("/laudos")
    public List<Laudo> list(){
        return laudoService.list();
    }

    @PostMapping("/laudos")
    public void save(@RequestBody Laudo l) {
        laudoService.add(l);
    }

    @DeleteMapping("/laudos/{idLaudo}")
    public void delete(@PathVariable long idLaudo) {
        laudoService.deleteById(idLaudo);
    }

    @RequestMapping("/laudos/{idLaudo}")
    public Laudo findById(@PathVariable long idLaudo) {
        return laudoService.findById(idLaudo).get();
    }

    @PutMapping("/laudos/{idLaudo}")
    public void update(@PathVariable long idLaudo, @RequestBody Laudo newLaudo) {
        Optional<Laudo> oldLaudo = laudoService.findById(idLaudo);
        if (oldLaudo.isPresent()) {
            Laudo laudo = oldLaudo.get();
            laudo.setText(newLaudo.getText());
            laudo.setAtendimento(newLaudo.getAtendimento());
            laudo.setMedico(newLaudo.getMedico());
            laudoService.add(laudo);
        }
    }
}

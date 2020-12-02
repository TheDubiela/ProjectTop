package br.com.animati;

import br.com.animati.entity.Medico;
import br.com.animati.service.MedicoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MedicoTests {
    @Autowired
    private MedicoService medicoService;

    void init() {
        Medico m1 = new Medico();
        m1.setNome("Andre Jobim");
        m1.setCpf("0020020002-22");

        medicoService.add(m1);

        Medico m2 = new Medico();
        m2.setNome("Rafael Scheidt");
        m2.setCpf("0010010001-12");

        medicoService.add(m2);
    }

    @Test
    void listTest() {
        init();
        List<Medico> list = medicoService.list();
        assertEquals(2, list.size());
    }

    @Test
    void deleteTest() {
        Medico medico = medicoService.findById(1).get();
        medicoService.delete(medico);

        List<Medico> list = medicoService.list();
        assertEquals(1, list.size());
    }

    @Test
    void editTest() {
        Medico medico = medicoService.findById(2).get();
        String nome = "Joao Silva";
        medico.setNome(nome);
        medicoService.add(medico);

        medico = medicoService.findById(2).get();
        assertEquals(nome, medico.getNome());
    }
}

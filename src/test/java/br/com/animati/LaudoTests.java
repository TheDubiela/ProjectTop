package br.com.animati;

import br.com.animati.entity.Atendimento;
import br.com.animati.entity.Laudo;
import br.com.animati.entity.Medico;
import br.com.animati.entity.Paciente;
import br.com.animati.service.AtendimentoService;
import br.com.animati.service.LaudoService;
import br.com.animati.service.MedicoService;
import br.com.animati.service.PacienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LaudoTests {
    @Autowired
    LaudoService laudoService;

    @Autowired
    MedicoService medicoService;

    @Autowired
    PacienteService pacienteService;

    @Autowired
    AtendimentoService atendimentoService;

    private void initMedico(){
        Medico m1 = new Medico();
        m1.setNome("Andre Jobim");
        m1.setCpf("0020020002-22");
        m1.setUf("524682");

        medicoService.add(m1);
    }

    private void initPacientes() {
        Paciente p1 = new Paciente();
        p1.setNome("Andre Jobim");
        p1.setCpf("0020020002-22");

        pacienteService.add(p1);
    }

    private void initAtendimentos() {
        initPacientes();

        Atendimento ate1 = new Atendimento();
        ate1.setNomeProcedimento("RX MAO DIREITA");
        ate1.setDataHora("22/11/2020 16:00:00");
        ate1.setPaciente(pacienteService.findById(2).get());
        ate1.setMedico(medicoService.findById(1).get());
        atendimentoService.add(ate1);

    }

    private void initLaudo(){
        initMedico();
        initAtendimentos();

        Laudo laudo = new Laudo();
        laudo.setMedico(medicoService.findById(1).get());
        laudo.setAtendimento(atendimentoService.findById(3).get());
        laudo.setText("text");
        laudoService.add(laudo);
    }

    @Test
    public void listTest() {
        initLaudo();

        List<Laudo> list = laudoService.list();
        for (Laudo laudo : list) {
            System.out.println(laudo.getText());
        }
    }
}

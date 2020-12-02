package br.com.animati.service;

import br.com.animati.entity.Medico;

import java.util.List;
import java.util.Optional;

public interface MedicoService {
    void add(Medico m);

    List<Medico> list();

    void delete(Medico medico);

    Optional<Medico> findById(long idMedico);

    void deleteById(Long idMedico);
}

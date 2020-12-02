package br.com.animati.service;

import br.com.animati.entity.Laudo;

import java.util.List;
import java.util.Optional;

public interface LaudoService {

    void add(Laudo laudo);

    List<Laudo> list();

    void delete(Laudo laudo);

    Optional<Laudo> findById(long idLaudo);

    void deleteById(Long idLaudo);
}

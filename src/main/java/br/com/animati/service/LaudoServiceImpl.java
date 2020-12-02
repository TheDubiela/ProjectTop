package br.com.animati.service;

import br.com.animati.dao.LaudoDAO;
import br.com.animati.entity.Laudo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaudoServiceImpl implements LaudoService{

    @Autowired
    private LaudoDAO dao;

    @Override
    public void add(Laudo laudo) {
        dao.save(laudo);
    }

    @Override
    public List<Laudo> list() {
        return dao.findAll();
    }

    @Override
    public void delete(Laudo laudo) {
        dao.delete(laudo);
    }

    @Override
    public Optional<Laudo> findById(long idLaudo) {
        return dao.findById(idLaudo);
    }

    @Override
    public void deleteById(Long idLaudo) {
        dao.deleteById(idLaudo);
    }
}

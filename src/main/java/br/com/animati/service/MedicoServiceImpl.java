package br.com.animati.service;

import br.com.animati.dao.MedicoDAO;
import br.com.animati.entity.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements MedicoService{

    @Autowired
    private MedicoDAO dao;

    @Override
    public void add(Medico m) {
        dao.save(m);
    }

    @Override
    public List<Medico> list() {
        return dao.findAll();
    }

    @Override
    public void delete(Medico medico) {
        dao.delete(medico);
    }

    @Override
    public Optional<Medico> findById(long idMedico) {
        return dao.findById(idMedico);
    }

    @Override
    public void deleteById(Long idMedico) {
        dao.deleteById(idMedico);
    }
}

package br.com.animati.dao;

import br.com.animati.entity.Laudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaudoDAO extends JpaRepository<Laudo, Long> {
}

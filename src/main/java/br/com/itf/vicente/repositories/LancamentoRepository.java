package br.com.itf.vicente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itf.vicente.model.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Integer>{
}

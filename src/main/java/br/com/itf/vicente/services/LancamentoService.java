package br.com.itf.vicente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.itf.vicente.repositories.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private final LancamentoRepository lancamentoRepository = null;
}

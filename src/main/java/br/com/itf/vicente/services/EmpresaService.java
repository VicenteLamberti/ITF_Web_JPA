package br.com.itf.vicente.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.itf.vicente.model.Empresa;
import br.com.itf.vicente.repositories.EmpresaRepository;

@Service
public class EmpresaService {


	
	private EmpresaRepository empresaRepository;
	
	public EmpresaService(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}

	public List<Empresa> buscarEmpresas(){
		return empresaRepository.findAll();
	}
	
}

package br.com.itf.vicente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.itf.vicente.model.Empresa;
import br.com.itf.vicente.repositories.EmpresaRepository;

@Service
public class EmpresaService {


	@Autowired
	private EmpresaRepository empresaRepository;
	
	
	public List<Empresa> buscarEmpresas(){
		return empresaRepository.findAll();
	}
	
}

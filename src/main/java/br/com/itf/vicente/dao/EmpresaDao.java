package br.com.itf.vicente.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.itf.vicente.model.Empresa;

public class EmpresaDao {

	private EntityManager em;
	
	public EmpresaDao(EntityManager em) {
		this.em = em;
	}

	public List<Empresa> list() {

		String jpql = "SELECT emp from Empresa emp";
		
		List<Empresa> list = em.createQuery(jpql, Empresa.class).getResultList();
		for (Empresa empresa : list) {
			System.out.println(empresa.getNome());
		}
		return list;

	}

	public Empresa listEmpresaById(Integer codigo) {
		return em.find(Empresa.class, codigo);
	}
}

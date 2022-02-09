package br.com.itf.vicente.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.itf.vicente.model.Lancamento;

public class LancamentoDao {
	private EntityManager em;

	public LancamentoDao(EntityManager em) {
		this.em = em;
	}

	public List<Lancamento> listLancamento() {
		String jpql = "SELECT lanc FROM Lancamento lanc";
		return em.createQuery(jpql,Lancamento.class).getResultList();
	}

	
	public void cadastrar(Lancamento lancamento) {
		System.out.println(lancamento);
		em.getTransaction().begin();
		this.em.persist(lancamento);
		em.getTransaction().commit();
		em.close();
		System.out.println(lancamento);
		System.out.println("Cadastrado DAO");
		
	}

	public void excluir(Lancamento lancamento) {
		em.getTransaction().begin();
		lancamento = em.merge(lancamento);
		em.remove(lancamento);
		em.getTransaction().commit();
		em.close();
		System.out.println("Deletado DAO");
	}

}
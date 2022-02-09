package br.com.itf.vicente.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.itf.vicente.model.Empresa;
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

	

//	public void insertLancamento(Lancamento lancamento) {
//		try (Connection conn = JPAUtil.getConnection()) {
//			if (lancamento.getDataPagamento() != null) {
//				String query = "INSERT INTO lancamento (tipo,codigo_empresa,descricao,valor,pago,data_pagamento,data_vencimento) VALUES (?,?,?,?,?,?,?)";
//				PreparedStatement ps = conn.prepareStatement(query);
//				ps.setString(1, lancamento.getTipo().getDescricao());
//				ps.setInt(2, lancamento.getEmpresa().getCodigo());
//				ps.setString(3, lancamento.getDescricao());
//				ps.setDouble(4, lancamento.getValor());
//				ps.setBoolean(5, lancamento.isPago());
//				ps.setDate(6, new java.sql.Date(lancamento.getDataVencimento().getTime()));
//				ps.setDate(7, new java.sql.Date(lancamento.getDataPagamento().getTime()));
//
//				ps.executeUpdate();
//			} else {
//				String query = "INSERT INTO lancamento (tipo,codigo_empresa,descricao,valor,pago,data_vencimento) VALUES (?,?,?,?,?,?)";
//				PreparedStatement ps = conn.prepareStatement(query);
//				ps.setString(1, lancamento.getTipo().getDescricao());
//				ps.setInt(2, lancamento.getEmpresa().getCodigo());
//				ps.setString(3, lancamento.getDescricao());
//				ps.setDouble(4, lancamento.getValor());
//				ps.setBoolean(5, lancamento.isPago());
//
//				ps.setDate(6, new java.sql.Date(lancamento.getDataVencimento().getTime()));
//
//				ps.executeUpdate();
//			}
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//	}
	
	public void cadastrar(Lancamento lancamento) {
		this.em.persist(lancamento);
		
	}

	public void excluir(Lancamento lancamento) {
		em.remove(lancamento);
	}

}
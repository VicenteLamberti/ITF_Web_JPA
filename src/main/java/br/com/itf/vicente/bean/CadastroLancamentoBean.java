package br.com.itf.vicente.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.itf.vicente.dao.EmpresaDao;
import br.com.itf.vicente.dao.JPAUtil;
import br.com.itf.vicente.dao.LancamentoDao;
import br.com.itf.vicente.model.Empresa;
import br.com.itf.vicente.model.Lancamento;
import br.com.itf.vicente.model.TipoLancamento;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	private Lancamento lancamento;
	private List<Empresa> empresas;

	@PostConstruct
	public void init() {
		EntityManager em = JPAUtil.getEntityManaget();
		System.out.println("oi");
		EmpresaDao empresaDao = new EmpresaDao(em);
		System.out.println("oi2");
		this.empresas = empresaDao.list();
		System.out.println("o3s");
		
		
	}

	public void cadastrar() {
		EntityManager em = JPAUtil.getEntityManaget();
		LancamentoDao lancamentoDao = new LancamentoDao(em);
		lancamentoDao.cadastrar(this.lancamento);
		this.lancamento = new Lancamento();
		String msg = "Cadastro efetuado com sucesso";

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}

	public TipoLancamento[] getTiposLancamento() {
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		if(this.lancamento == null) {
			this.lancamento = new Lancamento();
		}
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public List<Empresa> getEmpresas() {
		if(empresas == null) {
			this.empresas = new ArrayList<Empresa>();
		}
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

}

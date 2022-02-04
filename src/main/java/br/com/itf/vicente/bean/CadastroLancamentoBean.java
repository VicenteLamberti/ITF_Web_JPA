package br.com.itf.vicente.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.itf.vicente.dao.EmpresaDao;
import br.com.itf.vicente.dao.LancamentoDao;
import br.com.itf.vicente.model.Empresa;
import br.com.itf.vicente.model.Lancamento;
import br.com.itf.vicente.model.TipoLancamento;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	private Lancamento lancamento = new Lancamento();
	private List<Empresa> empresas = new ArrayList<Empresa>();

	@PostConstruct
	public void init() {
		EmpresaDao empresaDao = new EmpresaDao();
		this.empresas = empresaDao.list();
	}

	public void cadastrar() {
		LancamentoDao lancamentoDao = new LancamentoDao();
		lancamentoDao.cadastrar(this.lancamento);
		this.lancamento = new Lancamento();
		String msg = "Cadastro efetuado com sucesso";

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}

	public TipoLancamento[] getTiposLancamento() {
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

}

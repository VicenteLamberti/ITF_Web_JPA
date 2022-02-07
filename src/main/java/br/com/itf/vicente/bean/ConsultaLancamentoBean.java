package br.com.itf.vicente.bean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.itf.vicente.dao.LancamentoDao;
import br.com.itf.vicente.model.Lancamento;



@Named
@ViewScoped
public class ConsultaLancamentoBean implements Serializable{
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private Lancamento lancamentoSelecionado;

	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}

	@PostConstruct
	public void inicializar()
	{
		LancamentoDao empresaLancamentoDAO = new LancamentoDao();
		this.lancamentos = empresaLancamentoDAO.listLancamento();
	}
	
	public List<Lancamento> getLancamentos(){
		return lancamentos;
	}
	
	public void excluirLancamento() {
		LancamentoDao lancamentoDao = new LancamentoDao();
		lancamentoDao.excluir(this.lancamentoSelecionado);
//		String msg;
//		if(valido == 1) {
//			
//			msg = "Lançamento excluído com sucesso!";
//			inicializar();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,msg,msg));
//			
//		}
//		else {
//			msg = "Ocorreu um erro ao excluir o lançamento!";
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,msg,msg));
//		}
	}
}

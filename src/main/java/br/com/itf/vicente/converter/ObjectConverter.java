package br.com.itf.vicente.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.com.itf.vicente.dao.EmpresaDao;
import br.com.itf.vicente.dao.JPAUtil;
import br.com.itf.vicente.model.Empresa;


@FacesConverter(forClass = Empresa.class)
public class ObjectConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Empresa retorno = null;
		
		if(value != null) {
			Integer valueConverted = Integer.valueOf(value);
			EntityManager em = JPAUtil.getEntityManager();
			EmpresaDao lancamentoDao = new EmpresaDao(em);
			retorno = lancamentoDao.listEmpresaById(valueConverted);
			
		}
		return retorno;
	}
	
	@Override
	public String getAsString(FacesContext arg0, UIComponent component, Object value) {
		if(value != null) {
			return String.valueOf(((Empresa)value).getCodigo());
		}
		else {
			return null;
		}
		
		
		
	}
}

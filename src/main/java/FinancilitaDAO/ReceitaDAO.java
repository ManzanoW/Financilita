package FinancilitaDAO;

import java.util.List;

import FinancilitaBean.ReceitaBean;
import FinancilitaException.DBException;

public interface ReceitaDAO {

	void cadastrar(ReceitaBean ReceitaBean) throws DBException;

	void atualizar(ReceitaBean ReceitaBean) throws DBException;

	void remover(int cd_receita) throws DBException;

	ReceitaBean buscar(int id);

	List<ReceitaBean> listar();

}

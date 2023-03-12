package FinancilitaDAO;

import java.util.List;

import FinancilitaBean.InvestBean;
import FinancilitaException.DBException;

public interface InvestDAO {
	void cadastrar(InvestBean InvestBean) throws DBException;

	void atualizar(InvestBean InvestBean) throws DBException;

	void remover(int cd_receita) throws DBException;

	InvestBean buscar(int id);

	List<InvestBean> listar();

}

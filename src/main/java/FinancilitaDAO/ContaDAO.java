package FinancilitaDAO;

import java.util.List;

import FinancilitaBean.ContaBean;
import FinancilitaException.DBException;

public interface ContaDAO {

	void cadastrar(ContaBean ContaBean) throws DBException;

	void atualizar(ContaBean ContaBean) throws DBException;

	void remover(long user_cpf) throws DBException;

	ContaBean buscar(String user_cpf);

	List<ContaBean> listar();

}

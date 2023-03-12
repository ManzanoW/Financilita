package FinancilitaDAO;

import java.util.List;

import FinancilitaBean.DespesaBean;
import FinancilitaException.DBException;

public interface DespesaDao {

	void cadastrar(DespesaBean DespesaBean) throws DBException;

	void atualizar(DespesaBean DespesaBean) throws DBException;

	void remover(int cd_despesa) throws DBException;

	DespesaBean buscar(int id);

	List<DespesaBean> listar();
}

package FinancilitaDAO;

import java.util.List;

import FinancilitaBean.CartaoBean;
import FinancilitaException.DBException;

public interface CartaoDAO {

	void cadastrar(CartaoBean CartaoBean) throws DBException;

	void atualizar(CartaoBean CartaoBean) throws DBException;

	void remover(int cd_receita) throws DBException;

	CartaoBean buscar(int id_cartao);

	List<CartaoBean> listar();
}

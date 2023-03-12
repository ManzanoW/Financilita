package FinancilitaFactoryDAO;

import FinancilitaDAO.CartaoDAO;
import FinancilitaDAOImp.copy.OracleCartaoDAO;

public class CartaoFactoryDAO {

	public static CartaoDAO getCartaoDAO() {
		return new OracleCartaoDAO();
	}
}

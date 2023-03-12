package FinancilitaFactoryDAO;

import FinancilitaDAO.ReceitaDAO;
import FinancilitaDAOImp.copy.OracleReceitaDAO;

public class ReceitaFactoryDAO {

	public static ReceitaDAO getReceitaDAO() {
		return new OracleReceitaDAO();
	}

}

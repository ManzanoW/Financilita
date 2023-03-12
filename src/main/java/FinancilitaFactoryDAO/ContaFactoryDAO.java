package FinancilitaFactoryDAO;

import FinancilitaDAO.ContaDAO;
import FinancilitaDAOImp.copy.OracleContaDAO;

public class ContaFactoryDAO {

	public static ContaDAO getContaDAO() {
		return new OracleContaDAO();
	}

}

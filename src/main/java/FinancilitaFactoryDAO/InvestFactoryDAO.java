package FinancilitaFactoryDAO;

import FinancilitaDAO.InvestDAO;
import FinancilitaDAOImp.copy.OracleInvestDAO;

public class InvestFactoryDAO {
	public static InvestDAO getInvestDAO() {
		return new OracleInvestDAO();
	}

}

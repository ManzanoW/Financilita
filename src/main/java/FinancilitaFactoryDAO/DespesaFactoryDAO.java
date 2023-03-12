package FinancilitaFactoryDAO;

import FinancilitaDAO.DespesaDao;
import FinancilitaDAOImp.copy.OracleDespesaDAO;

public class DespesaFactoryDAO {

	public static DespesaDao getDespesaDAO() {
		return new OracleDespesaDAO();
	}

}

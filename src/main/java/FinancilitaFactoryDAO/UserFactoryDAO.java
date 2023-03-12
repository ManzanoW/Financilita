package FinancilitaFactoryDAO;

import FinancilitaDAO.UserDAO;
import FinancilitaDAOImp.copy.OracleUserDAO;

public class UserFactoryDAO {

	public static UserDAO getUserDAO() {
		return new OracleUserDAO();
	}

}
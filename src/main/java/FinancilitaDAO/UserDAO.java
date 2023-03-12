package FinancilitaDAO;

import FinancilitaBean.UserBean;
import FinancilitaException.DBException;

public interface UserDAO {

	boolean validarUser(UserBean UserBean) throws DBException;
	
}
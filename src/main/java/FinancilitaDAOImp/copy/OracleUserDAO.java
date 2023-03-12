package FinancilitaDAOImp.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import FinancilitaBean.UserBean;
import FinancilitaDAO.UserDAO;
import FinancilitaSigleton.ConnectionManager;

public class OracleUserDAO implements UserDAO{
	
	private Connection conexao;

	@Override
	public boolean validarUser(UserBean UserBean) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_CONTAS WHERE USER_EMAIL = ? AND USER_PASSWORD = ?");
			stmt.setString(1, UserBean.getEmail());
			stmt.setString(2, UserBean.getPassword());
			rs = stmt.executeQuery();

			if (rs.next()){
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
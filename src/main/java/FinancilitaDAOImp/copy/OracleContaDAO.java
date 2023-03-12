package FinancilitaDAOImp.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import FinancilitaBean.ContaBean;
import FinancilitaDAO.ContaDAO;
import FinancilitaException.DBException;
import FinancilitaSigleton.ConnectionManager;

public class OracleContaDAO implements ContaDAO {
	private Connection conexao;

	@Override
	public void cadastrar(ContaBean ContaBean) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();

			String sql = "INSERT INTO T_CONTAS(NM_CLIENTE,NM_USER,USER_EMAIL,T_USER_CPF_USER,USER_PASSWORD)VALUES(?,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, ContaBean.getNm_cliente());
			stmt.setString(2, ContaBean.getNm_user());
			stmt.setString(3, ContaBean.getUser_email());
			stmt.setString(4, ContaBean.getUser_cpf());
			stmt.setString(5, ContaBean.getPassword());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastradar.");

		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void atualizar(ContaBean ContaBean) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();

			String sql = "UPDATE T_CONTA SET NM_CLIENTE = ?, NM_USER = ?, USER_EMAIL = ?,USER_PASSWORD=? WHERE T_USER_CPF_USER = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, ContaBean.getNm_cliente());
			stmt.setString(2, ContaBean.getNm_user());
			stmt.setString(3, ContaBean.getUser_email());
			stmt.setString(4, ContaBean.getPassword());
			stmt.setString(5, ContaBean.getUser_cpf());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");

		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void remover(long user_cpf) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_CONTA WHERE T_USER_CPF_USER = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, user_cpf);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public ContaBean buscar(String user_cpf) {
		ContaBean ContaBean = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_CONTA WHERE T_USER_CPF_USER = ?");
			stmt.setString(1, user_cpf);
			rs = stmt.executeQuery();

			if (rs.next()) {
				String nomeCliente = rs.getString("NM_CLIENTE");
				String username = rs.getString("NM_USER");
				String email = rs.getString("USER_EMAIL");
				String cpf = rs.getString("USER_CPF");
				String senha = rs.getString("USER_CPF");

				ContaBean = new ContaBean(nomeCliente, username, email, cpf, senha);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ContaBean;
	}

	@Override
	public List<ContaBean> listar() {
		List<ContaBean> lista = new ArrayList<ContaBean>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_CONTA");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados

			while (rs.next()) {
				String nomeCliente = rs.getString("NM_CLIENTE");
				String username = rs.getString("NM_USER");
				String email = rs.getString("USER_EMAIL");
				String cpf = rs.getString("USER_CPF");
				String senha = rs.getString("PASSWORD");

				ContaBean ContaBean = new ContaBean(nomeCliente, username, email, cpf, senha);
				lista.add(ContaBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
	
	
	
	

}

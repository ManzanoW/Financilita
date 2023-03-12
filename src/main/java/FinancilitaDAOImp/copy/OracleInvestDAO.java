package FinancilitaDAOImp.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import FinancilitaBean.InvestBean;
import FinancilitaDAO.InvestDAO;
import FinancilitaException.DBException;
import FinancilitaSigleton.ConnectionManager;

public class OracleInvestDAO implements InvestDAO {

	private Connection conexao;

	@Override
	public void cadastrar(InvestBean InvestBean) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();

			String sql = "INSERT INTO T_INVESTIMENTOS(CD_INVESTIMENTO,NM_INVESTIMENTO,VL_INVESTIMENTO,DT_INVESTIMENTO,REND_INVESTIMENTO)VALUES(SQ.NEXTVAL,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			// stmt.setInt(1, InvestBean.getCd_despesa());
			stmt.setString(1, InvestBean.getNm_invest());
			stmt.setDouble(2, InvestBean.getVl_invest());
			stmt.setDouble(4, InvestBean.getRend_invest());
			java.sql.Date data = new java.sql.Date(InvestBean.getDt_invest().getTimeInMillis());
			stmt.setDate(3, data);

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
	public void atualizar(InvestBean InvestBean) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();

			String sql = "UPDATE T_INVESTIMENTOS SET NM_INVESTIMENTO = ?, VL_INVESTIMENTO = ?, DT_INVESTIMENTO = ?, REND_INVESTIMENTO = ? WHERE CD_INVESTIMENTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, InvestBean.getNm_invest());
			stmt.setDouble(2, InvestBean.getVl_invest());
			stmt.setDouble(4, InvestBean.getRend_invest());
			java.sql.Date data = new java.sql.Date(InvestBean.getDt_invest().getTimeInMillis());
			stmt.setDate(3, data);

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
	public void remover(int cd_invest) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_INVESTIMENTOS WHERE CD_INVESTIMENTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cd_invest);
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
	public InvestBean buscar(int cd_invest) {
		InvestBean InvestBean = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_INVESTIMENTOS WHERE CD_INVESTIMENTO = ?");
			stmt.setInt(1, cd_invest);
			rs = stmt.executeQuery();

			if (rs.next()) {
				String nome = rs.getString("NM_INVESTIMENTO");
				double valor = rs.getDouble("VALOR_DESPESA");
				java.sql.Date data = rs.getDate("DT_INVESTIMENTO");
				Calendar date = Calendar.getInstance();
				date.setTimeInMillis(data.getTime());
				double rendi = rs.getDouble("REND_INVESTIMENTO");
				int codigo = rs.getInt("CD_INVESTIMENTO");

				InvestBean = new InvestBean(codigo,nome, valor, date, rendi);
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
		return InvestBean;
	}

	@Override
	public List<InvestBean> listar() {
		List<InvestBean> lista = new ArrayList<InvestBean>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_DESPESAS");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados

			while (rs.next()) {
				String nome = rs.getString("NM_INVESTIMENTO");
				double valor = rs.getDouble("VALOR_DESPESA");
				java.sql.Date data = rs.getDate("DT_INVESTIMENTO");
				Calendar date = Calendar.getInstance();
				date.setTimeInMillis(data.getTime());
				double rendi = rs.getDouble("REND_INVESTIMENTO");
				int codigo = rs.getInt("CD_INVESTIMENTO");

				InvestBean InvestBean = new InvestBean(codigo,nome, valor, date, rendi);

				lista.add(InvestBean);
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

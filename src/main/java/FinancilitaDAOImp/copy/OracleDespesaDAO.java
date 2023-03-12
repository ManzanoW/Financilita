package FinancilitaDAOImp.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;

import FinancilitaBean.DespesaBean;
import FinancilitaDAO.DespesaDao;
import FinancilitaException.DBException;
import FinancilitaSigleton.ConnectionManager;

public class OracleDespesaDAO implements DespesaDao {

	private Connection conexao;

	@Override
	public void cadastrar(DespesaBean DespesaBean) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();

			String sql = "INSERT INTO T_DESPESAS(ID_DESPESA,NM_DESPESA,VALOR_DESPESA,DATA_DESPESA,RECORRENTE)VALUES(SQ.NEXTVAL,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			//stmt.setInt(1, DespesaBean.getCd_despesa());
			stmt.setString(1, DespesaBean.getNm_despesa());
			stmt.setDouble(2, DespesaBean.getVl_despesa());
			stmt.setBoolean(4, DespesaBean.isSe_mensal());
			java.sql.Date data = new java.sql.Date(DespesaBean.getDt_despesa().getTimeInMillis());
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
	public void atualizar(DespesaBean DespesaBean) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();

			String sql = "UPDATE T_DESPESAS SET NM_DESPESA = ?, VALOR_DESPESA = ?, RECORRENTE = ?, DATA_DESPESA = ? WHERE ID_DESPESA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, DespesaBean.getNm_despesa());
			stmt.setDouble(2, DespesaBean.getVl_despesa());
			stmt.setBoolean(3, DespesaBean.isSe_mensal());
			java.sql.Date data = new java.sql.Date(DespesaBean.getDt_despesa().getTimeInMillis());
			stmt.setDate(4, data);
			stmt.setInt(5, DespesaBean.getCd_despesa());

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
	public void remover(int cd_despesa) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_DESPESAS WHERE ID_DESPESA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cd_despesa);
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
	public DespesaBean buscar(int id) {
		DespesaBean DespesaBean = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_DESPESAS WHERE ID_DESPESA = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigo = rs.getInt("ID_DESPESA");
				String nome = rs.getString("NM_DESPESA");
				boolean reco = rs.getBoolean("RECORRENTE");
				double valor = rs.getDouble("VALOR_DESPESA");
				java.sql.Date data = rs.getDate("DATA_DESPESA");
				Calendar dataFabricacao = Calendar.getInstance();
				dataFabricacao.setTimeInMillis(data.getTime());

				DespesaBean = new DespesaBean(codigo, nome, valor, dataFabricacao, reco);
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
		return DespesaBean;
	}

	@Override
	public List<DespesaBean> listar() {
		List<DespesaBean> lista = new ArrayList<DespesaBean>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_DESPESAS");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados

			while (rs.next()) {
				int codigo = rs.getInt("ID_DESPESA");
				String nome = rs.getString("NM_DESPESA");
				boolean reco = rs.getBoolean("RECORRENTE");
				double valor = rs.getDouble("VALOR_DESPESA");
				java.sql.Date data = rs.getDate("DATA_DESPESA");
				Calendar dataFabricacao = Calendar.getInstance();
				dataFabricacao.setTimeInMillis(data.getTime());

				DespesaBean DespesaBean = new DespesaBean(codigo, nome, valor, dataFabricacao, reco);
				lista.add(DespesaBean);
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

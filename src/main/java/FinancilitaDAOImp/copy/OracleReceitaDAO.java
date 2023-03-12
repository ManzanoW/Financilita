package FinancilitaDAOImp.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import FinancilitaBean.ReceitaBean;
import FinancilitaDAO.ReceitaDAO;
import FinancilitaException.DBException;
import FinancilitaSigleton.ConnectionManager;

public class OracleReceitaDAO implements ReceitaDAO {

	private Connection conexao;

	@Override
	public void cadastrar(ReceitaBean ReceitaBean) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();

			String sql = "INSERT INTO T_RECEITAS(ID_RECEITA,NM_RECEITA,VALOR_RECEITA,DATA_RECEITA,RECORRENTE)VALUES(SQ.NEXTVAL,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			// stmt.setInt(1, ReceitaBean.getCd_receita());
			stmt.setString(1, ReceitaBean.getNm_receita());
			stmt.setDouble(2, ReceitaBean.getVl_receita());
			stmt.setBoolean(4, ReceitaBean.isSe_mensal());
			java.sql.Date data = new java.sql.Date(ReceitaBean.getDt_receita().getTimeInMillis());
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
	public void atualizar(ReceitaBean ReceitaBean) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();

			String sql = "UPDATE T_RECEITAS SET NM_RECEITA = ?, VALOR_RECEITA = ?, RECORRENTE = ?, DT_RECEITA = ? WHERE ID_RECEITA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, ReceitaBean.getNm_receita());
			stmt.setDouble(2, ReceitaBean.getVl_receita());
			stmt.setBoolean(3, ReceitaBean.isSe_mensal());
			java.sql.Date data = new java.sql.Date(ReceitaBean.getDt_receita().getTimeInMillis());
			stmt.setDate(5, data);
			stmt.setInt(4, ReceitaBean.getCd_receita());

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
	public void remover(int cd_receita) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_RECEITAS WHERE ID_RECEITA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cd_receita);
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
	public ReceitaBean buscar(int id) {
		ReceitaBean ReceitaBean = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_RECEITAS WHERE ID_RECEITA = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigo = rs.getInt("ID_RECEITA");
				String nome = rs.getString("NM_RECEITA");
				boolean reco = rs.getBoolean("RECORRENTE");
				double valor = rs.getDouble("VALOR_RECEITA");
				java.sql.Date data = rs.getDate("DATA_RECEITA");
				Calendar dataFabricacao = Calendar.getInstance();
				dataFabricacao.setTimeInMillis(data.getTime());

				ReceitaBean = new ReceitaBean(codigo, nome, valor, dataFabricacao, reco);
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
		return ReceitaBean;
	}

	@Override
	public List<ReceitaBean> listar() {
		List<ReceitaBean> lista = new ArrayList<ReceitaBean>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_RECEITAS");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados

			while (rs.next()) {
				int codigo = rs.getInt("ID_RECEITA");
				String nome = rs.getString("NM_RECEITA");
				boolean reco = rs.getBoolean("RECORRENTE");
				double valor = rs.getDouble("VALOR_RECEITA");
				java.sql.Date data = rs.getDate("DATA_RECEITA");
				Calendar dataFabricacao = Calendar.getInstance();
				dataFabricacao.setTimeInMillis(data.getTime());

				ReceitaBean ReceitaBean = new ReceitaBean(codigo, nome, valor, dataFabricacao, reco);
				lista.add(ReceitaBean);
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

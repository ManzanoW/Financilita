package FinancilitaBean;

import java.util.Calendar;

public class ReceitaBean {

	private String nm_receita;
	private int cd_receita;
	private double vl_receita;
	private Calendar dt_receita;
	private boolean se_mensal;

	public ReceitaBean() {

	}

	public ReceitaBean(int cd_receita, String nm_receita, double vl_receita, Calendar dt_receita, boolean se_mensal) {
		super();
		this.cd_receita = cd_receita;
		this.vl_receita = vl_receita;
		this.dt_receita = dt_receita;
		this.se_mensal = se_mensal;
		this.nm_receita = nm_receita;
	}

	public int getCd_receita() {
		return cd_receita;
	}

	public void setCd_receita(int cd_receita) {
		this.cd_receita = cd_receita;
	}

	public double getVl_receita() {
		return vl_receita;
	}

	public void setVl_receita(double vl_receita) {
		this.vl_receita = vl_receita;
	}

	public Calendar getDt_receita() {
		return dt_receita;
	}

	public void setDt_receita(Calendar dt_receita) {
		this.dt_receita = dt_receita;
	}

	public boolean isSe_mensal() {
		return se_mensal;
	}

	public void setSe_mensal(boolean se_mensal) {
		this.se_mensal = se_mensal;
	}

	public String getNm_receita() {
		return nm_receita;
	}

	public void setNm_receita(String nm_receita) {
		this.nm_receita = nm_receita;
	}

}

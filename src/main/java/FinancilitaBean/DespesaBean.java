package FinancilitaBean;

import java.util.Calendar;
import java.util.Date;

public class DespesaBean {

	private String nm_despesa;
	private int cd_despesa;
	private double vl_despesa;
	private Calendar dt_despesa;
	private boolean se_mensal;

	public DespesaBean() {
	}

	public DespesaBean(int cd_despesa, String nm_despesa, double vl_despesa, Calendar dt_despesa, boolean se_mensal) {
		super();
		this.cd_despesa = cd_despesa;
		this.vl_despesa = vl_despesa;
		this.dt_despesa = dt_despesa;
		this.se_mensal = se_mensal;
		this.nm_despesa = nm_despesa;
	}

	public int getCd_despesa() {
		return cd_despesa;
	}

	public void setCd_despesa(int cd_despesa) {
		this.cd_despesa = cd_despesa;
	}

	public double getVl_despesa() {
		return vl_despesa;
	}

	public void setVl_despesa(double vl_despesa) {
		this.vl_despesa = vl_despesa;
	}

	public Calendar getDt_despesa() {
		return dt_despesa;
	}

	public void setDt_despesa(Calendar dt_despesa) {
		this.dt_despesa = dt_despesa;
	}

	public boolean isSe_mensal() {
		return se_mensal;
	}

	public void setSe_mensal(boolean se_mensal) {
		this.se_mensal = se_mensal;
	}

	public String getNm_despesa() {
		return nm_despesa;
	}

	public void setNm_despesa(String nm_despesa) {
		this.nm_despesa = nm_despesa;
	}
}

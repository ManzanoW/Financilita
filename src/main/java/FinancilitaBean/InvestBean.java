package FinancilitaBean;

import java.util.Calendar;

public class InvestBean {

	private int cd_invest;
	private String nm_invest;
	private double vl_invest;
	private Calendar dt_invest;
	private double rend_invest;

	public InvestBean() {

	}

	public InvestBean(int cd_invest ,String nm_invest, double vl_invest, Calendar dt_invest, double rend_invest ) {
		super();
		this.nm_invest = nm_invest;
		this.vl_invest = vl_invest;
		this.dt_invest = dt_invest;
		this.rend_invest = rend_invest;
		this.cd_invest = cd_invest;
	}

	public String getNm_invest() {
		return nm_invest;
	}

	public void setNm_invest(String nm_invest) {
		this.nm_invest = nm_invest;
	}

	public double getVl_invest() {
		return vl_invest;
	}

	public void setVl_invest(double vl_invest) {
		this.vl_invest = vl_invest;
	}

	public Calendar getDt_invest() {
		return dt_invest;
	}

	public void setDt_invest(Calendar dt_invest) {
		this.dt_invest = dt_invest;
	}

	public double getRend_invest() {
		return rend_invest;
	}

	public void setRend_invest(double rend_invest) {
		this.rend_invest = rend_invest;
	}

	public int getCd_invest() {
		return cd_invest;
	}

	public void setCd_invest(int cd_Invest) {
		this.cd_invest = cd_Invest;
	}

}

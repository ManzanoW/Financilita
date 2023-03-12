package FinancilitaBean;

public class CartaoBean {

	private int cd_cartao;
	private int id_cartao;
	private int num_last4;
	private String nm_cartao;

	public CartaoBean() {

	}

	public CartaoBean(int cd_cartao, int id_cartao, int num_last4, String nm_cartao) {
		super();
		this.cd_cartao = cd_cartao;
		this.id_cartao = id_cartao;
		this.num_last4 = num_last4;
		this.nm_cartao = nm_cartao;
	}

	public int getCd_cartao() {
		return cd_cartao;
	}

	public void setCd_cartao(int cd_cartao) {
		this.cd_cartao = cd_cartao;
	}

	public int getId_cartao() {
		return id_cartao;
	}

	public void setId_cartao(int id_cartao) {
		this.id_cartao = id_cartao;
	}

	public int getNun_last4() {
		return num_last4;
	}

	public void setNun_last4(int nun_last4) {
		this.num_last4 = nun_last4;
	}

	public String getNm_cartao() {
		return nm_cartao;
	}

	public void setNm_cartao(String nm_cartao) {
		this.nm_cartao = nm_cartao;
	}

}

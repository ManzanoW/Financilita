package FinancilitaBean;

import java.math.BigInteger;

public class ContaBean {

	private String nm_cliente;
	private String nm_user;
	private String user_email;
	private String user_cpf;
	private String password;

	public ContaBean() {

	}

	public ContaBean(String nm_cliente, String nm_user, String user_email, String user_cpf, String password) {
		super();
		this.nm_cliente = nm_cliente;
		this.nm_user = nm_user;
		this.user_email = user_email;
		this.user_cpf = user_cpf;
		this.password = password;
	}

	public String getNm_cliente() {
		return nm_cliente;
	}

	public void setNm_cliente(String nm_cliente) {
		this.nm_cliente = nm_cliente;
	}

	public String getNm_user() {
		return nm_user;
	}

	public void setNm_user(String nm_user) {
		this.nm_user = nm_user;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_cpf() {
		return user_cpf;
	}

	public void setUser_cpf(String user_cpf) {
		this.user_cpf = user_cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

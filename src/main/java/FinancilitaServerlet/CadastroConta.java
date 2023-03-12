package FinancilitaServerlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FinancilitaBean.*;
import FinancilitaDAO.*;
import FinancilitaFactoryDAO.*;
import FinancilitaException.DBException;

@WebServlet("/cadastroconta")
public class CadastroConta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ContaDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = ContaFactoryDAO.getContaDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String nome = request.getParameter("nome");
			String userName = request.getParameter("nomeUser");
			String email = (request.getParameter("email"));
			String cpf = request.getParameter("cpf");
			String senha = (request.getParameter("senha"));

			ContaBean conta = new ContaBean(nome, userName, email, cpf, senha);
			dao.cadastrar(conta);

			request.setAttribute("msg", "Conta Criada!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao criar Conta");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

}
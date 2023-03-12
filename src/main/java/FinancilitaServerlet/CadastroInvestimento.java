package FinancilitaServerlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FinancilitaBean.*;
import FinancilitaDAO.*;
import FinancilitaFactoryDAO.*;
import FinancilitaException.DBException;


@WebServlet("/Investimento")
public class CadastroInvestimento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InvestDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = InvestFactoryDAO.getInvestDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<InvestBean> lista = dao.listar();
		request.setAttribute("investimento", lista);
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		
		try {
			String nome = request.getParameter("nome");
			Double valor = Double.parseDouble(request.getParameter("valor"));
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar data= Calendar.getInstance();
			data.setTime(format.parse(request.getParameter("data")));
			
			Double rendi = Double.parseDouble(request.getParameter("rendi"));

			InvestBean invest = new InvestBean(0,nome,valor,data,rendi);
			dao.cadastrar(invest);

			request.setAttribute("msg", "Investimento Cadastrado");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao criar investimento");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		request.getRequestDispatcher("investimento.jsp").forward(request, response);
	}

}

package FinancilitaServerlet;

import java.io.IOException;
import java.sql.Date;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.text.*;

import FinancilitaBean.*;
import FinancilitaDAO.*;
import FinancilitaFactoryDAO.*;
import FinancilitaException.DBException;



@WebServlet("/receita")
public class CadastroReceita extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReceitaDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = ReceitaFactoryDAO.getReceitaDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ReceitaBean> lista = dao.listar();
		request.setAttribute("receita", lista);
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);;
		
		try {
			boolean opcao = false;
			
			String nome = request.getParameter("nome");
			Double valor = Double.parseDouble(request.getParameter("valor"));
			String reco = request.getParameter("recorrente");
			
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar data= Calendar.getInstance();
			data.setTime(format.parse(request.getParameter("data")));
			
			
			
			 if(reco.toUpperCase().equals("SIM")) {
				
				opcao=true;
				
			}else {
				
				 opcao=false;
				 
			} 
			 
			
			System.out.println(reco);
			System.out.println(data);
			System.out.println(opcao);
			
			ReceitaBean receita = new ReceitaBean(0,nome,valor,data,opcao);
			dao.cadastrar(receita);

			request.setAttribute("msg", "Receita Cadastrada");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao criar Receita");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		request.getRequestDispatcher("receita.jsp").forward(request, response);
	}

}



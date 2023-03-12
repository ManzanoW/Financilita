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



@WebServlet("/despesa")
public class CadastroDespesa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DespesaDao dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DespesaFactoryDAO.getDespesaDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		List<DespesaBean> lista = dao.listar();
		request.setAttribute("despesa", lista);
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);

		try {
			
			boolean opcao;
			String nome = request.getParameter("nome");
			Double valor = Double.parseDouble(request.getParameter("valor"));
			String reco = request.getParameter("recorrente");
			System.out.println(reco);
			
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(request.getParameter("data")));
			
			
			
			if(reco.toUpperCase().equals("SIM")) {
				
				opcao=true;
				
			}else {
				
				 opcao=false;
			}
			
			System.out.println(data);
			DespesaBean despesa = new DespesaBean(0,nome,valor,data,opcao);
			dao.cadastrar(despesa);

			request.setAttribute("msg", "Despesa Cadastrada");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao criar Despesa");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		request.getRequestDispatcher("despesa.jsp").forward(request, response);
	}
	
}



package FinancilitaServerlet;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import FinancilitaBean.UserBean;
import FinancilitaException.DBException;
import FinancilitaDAO.UserDAO;
import FinancilitaFactoryDAO.UserFactoryDAO;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO dao;
  
	public LoginServlet() {
        dao = UserFactoryDAO.getUserDAO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserBean usuario = new UserBean(email, password);
		
		try {
			if (dao.validarUser(usuario)) {
				HttpSession session = request.getSession();
				session.setAttribute(email, password);
				String mensagem = "Um login foi realizado";
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
			}else {
				request.setAttribute("erro", "Usuário e/ou senha inválidos");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
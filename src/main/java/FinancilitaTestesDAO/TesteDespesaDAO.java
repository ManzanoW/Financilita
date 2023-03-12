package FinancilitaTestesDAO;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



import FinancilitaBean.DespesaBean;
import FinancilitaBean.ReceitaBean;
import FinancilitaDAO.DespesaDao;
import FinancilitaDAO.ReceitaDAO;
import FinancilitaException.DBException;

import FinancilitaFactoryDAO.DespesaFactoryDAO;
import FinancilitaFactoryDAO.ReceitaFactoryDAO;

public class TesteDespesaDAO {

	public static void main(String[] args) throws ParseException {

		ReceitaDAO dao = ReceitaFactoryDAO.getReceitaDAO();
		

        
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar data = Calendar.getInstance();
		data.setTime(format.parse("2000-12-5"));
		

		// cadastro teste

		System.out.println(data); 
		
		ReceitaBean conta = new ReceitaBean(0,"Aluguel",564065,data,true);
		try {
			dao.cadastrar(conta);
			System.out.println("Conta cadastrada.");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}

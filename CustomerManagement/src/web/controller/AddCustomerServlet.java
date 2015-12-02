package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Customer;
import exception.DaoException;
import service.impl.BusinessServiceImpl;
import utils.WebUtils;

public class AddCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			Customer customer = WebUtils.requestToBean(request, Customer.class);
			customer.setId(WebUtils.makeID());
			BusinessServiceImpl service = new BusinessServiceImpl();
			service.addCustomer(customer);
			request.setAttribute("message", "��ӳɹ������Ե�����鿴�ͻ������в鿴��");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (DaoException e) {
			e.printStackTrace();
			request.setAttribute("message", "�Բ������緱æ��");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

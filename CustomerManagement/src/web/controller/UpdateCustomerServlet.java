package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Customer;
import exception.DaoException;
import service.BusinessService;
import service.impl.BusinessServiceImpl;
import utils.WebUtils;

public class UpdateCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		try {
			Customer customer = WebUtils.requestToBean(request, Customer.class);
			BusinessService service = new BusinessServiceImpl();
			service.updateCustomer(customer);
			request.setAttribute("message", "���³ɹ�����ҳ�潫��3�����ת���ͻ��б�<meta http-equiv='refresh' content='3;url=/CustomerManagement/servlet/ListCustomerServlet'");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (DaoException e) {
			e.printStackTrace();
			request.setAttribute("message", "�Բ���ϵͳ��æ������ʧ�ܣ�");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

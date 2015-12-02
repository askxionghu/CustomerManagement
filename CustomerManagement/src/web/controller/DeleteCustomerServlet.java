package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.DaoException;
import service.BusinessService;
import service.impl.BusinessServiceImpl;

public class DeleteCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String customerid = request.getParameter("customerid");
			BusinessService service = new BusinessServiceImpl();
			service.deleteCustomer(customerid);
			request.setAttribute("message", "ɾ���ɹ�����ҳ�潫��3�����ת���ͻ��б�<meta http-equiv='refresh' content='3;url=/CustomerManagement/servlet/ListCustomerServlet'");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (DaoException e) {
			e.printStackTrace();
			request.setAttribute("message", "�Բ���ɾ��ʧ�ܣ�");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

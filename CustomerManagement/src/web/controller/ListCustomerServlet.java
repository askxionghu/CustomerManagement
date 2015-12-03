package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Customer;
import domain.Page;
import exception.DaoException;
import service.BusinessService;
import service.impl.BusinessServiceImpl;

public class ListCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		try {
			String pageNum = request.getParameter("pageNum");
			String servletName = this.getServletName();  //ע�����ﲻ��д��request.getServerName(); ������ص���localhost
			BusinessService service = new BusinessServiceImpl();
			Page page = service.getPageData(pageNum, request.getContextPath() + "/servlet/" + servletName);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/listCustomer.jsp").forward(request, response);
		} catch (DaoException e) {
			e.printStackTrace();
			request.setAttribute("message", "�Բ��𣬲鿴ʧ�ܣ�");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

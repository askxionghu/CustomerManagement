package junit;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import utils.Globals;
import utils.WebUtils;
import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import domain.Customer;
import exception.DaoException;

public class CustomerDaoTest {
	
	private CustomerDao dao = new CustomerDaoImpl();
	
	@Test
	public void testAddAndUpdateCustomer() throws Exception{
		Customer customer = new Customer();
		customer.setId("1");
		customer.setName("����");
		customer.setGender("��");
		customer.setEmail("ww@sina.com");
		customer.setBirthday(new Date());
		customer.setCellphone("123456778");
		customer.setLikes(Globals.preferences[3]);
		customer.setType(Globals.type[0]);
		customer.setDescription("һ������");
		dao.addCustomer(customer);
		//�������ϵ����
		customer.setGender("Ů");
		dao.updateCustomer(customer);
	}

	@Test
	public void testFindCustomer() throws Exception{
		Customer customer= dao.findCustomer("1");
		System.out.println(customer.getName());
	}
	
	@Test
	public void testDeleteCustomer() throws Exception{
		dao.deleteCustomer("1");
	}
	
	@Test 
	public void testGetAllCustomer() throws Exception{
		List<Customer> list = dao.getAll();
		for(Customer c : list){
			System.out.println(c.getName());
		}
	}
}

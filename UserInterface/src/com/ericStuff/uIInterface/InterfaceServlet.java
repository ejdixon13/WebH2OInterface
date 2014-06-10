package com.ericStuff.uIInterface;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InterfaceServlet
 */
@WebServlet("/InterfaceServlet")
public class InterfaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InterfaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("This will be an interface");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String custId = request.getParameter("custId");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		request.getSession().setAttribute("latitude", latitude);
		request.getSession().setAttribute("longitude", longitude);
		
		Customer cust = DatabaseHelper.getCustomer(Integer.parseInt(custId));
		if (cust != null){
			request.getSession().setAttribute("customer", cust);
		}
		else {
			Customer customer = new Customer();
			customer.setCustomerID(Integer.parseInt(custId));
			String address = String.valueOf((int)(Math.random()*1000)) + " E. "+ String.valueOf((int)(Math.random()*10)) + " st.";
			customer.setAddress(address);
			customer.setName("Arandom Customer");
			customer.setWaterUsed((int)(Math.random()*4000));
			DatabaseHelper.saveObject(customer);
			
			request.getSession().setAttribute("customer", customer);
		}
		//response.sendRedirect("http://ec2-54-86-147-29.compute-1.amazonaws.com:8080/UserInterface/viewCustomer.jsp");
		response.sendRedirect("http://localhost:8081/UserInterface/viewCustomer.jsp");
	}

}

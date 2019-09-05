package com.bank.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.domains.CustomerBean;
import com.bank.pool.Constants;
import com.bank.serviceimpls.MemberServiceImpl;
import com.bank.services.MemberService;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController¿¡ µµÂøÇÔ");
		System.out.println(request.getParameter("action"));
		System.out.println(request.getParameter("dest"));
		MemberService service = new MemberServiceImpl();
		CustomerBean param =null;


		switch(request.getParameter("action")) {
	
			
			case "move" : request.getRequestDispatcher(String.format
					(Constants.VIEW_PATH,"customer",request.getParameter("dest"))).forward(request, response);
					System.out.println("MemberController¿¡ µµÂøÇÔ1");
			
					break;
			
			case "join":
				System.out.println("MemberController¿¡ µµÂøÇÔ2");
			    String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String name = request.getParameter("name");
				String ssn = request.getParameter("ssn");
				String credit = request.getParameter("credit");
				param = new CustomerBean();
				param.setId(id);
				param.setPw(pw);
				param.setName(name);
				param.setSsn(ssn);
				param.setCredit(credit);
				System.out.println("È¸¿øÁ¤º¸ : "+ param.toString());
				service.join(param);
				request.getRequestDispatcher(String.format
						(Constants.VIEW_PATH,"customer",request.getParameter("dest"))).forward(request, response);
					break;
			 
			case "login" :
				System.out.println("MemberController¿¡ µµÂøÇÔ3");
			     id = request.getParameter("id");
				pw = request.getParameter("pw"); 
				param = new CustomerBean();
				param.setId(id);
				param.setPw(pw);
				System.out.println(param.toString());
				CustomerBean customer = service.login(param);
				if(param.getId().equals(customer.getId())&&param.getPw().equals(customer.getPw())) {
					request.setAttribute("customer", customer);
					request.getRequestDispatcher(String.format
							(Constants.VIEW_PATH,"customer",request.getParameter("dest"))).forward(request, response);
				}else {
					request.getRequestDispatcher(String.format
							(Constants.VIEW_PATH,"customer",request.getParameter("action"))).forward(request, response);
				}
					break;
			 
					
			case "existId" : 
				break;
					
			default:

			
					break;
		}
		
	 }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

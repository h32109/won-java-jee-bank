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

import com.bank.command.Sender;
import com.bank.command.Command;
import com.bank.command.MoveCommand;
import com.bank.command.Order;
import com.bank.command.Receiver;
import com.bank.domains.CustomerBean;
import com.bank.pool.Constants;
import com.bank.serviceimpls.MemberServiceImpl;
import com.bank.services.MemberService;

@WebServlet("/customer.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberService service = new MemberServiceImpl();
		CustomerBean param =new CustomerBean();
		Receiver.init(request);
		Receiver.cmd.execute();
		if(Receiver.cmd.getAction()==null) {
			Receiver.cmd.setPage( );
		}
		switch(Receiver.cmd.getAction()) {
			case "join":
				System.out.println("MemberController¿¡ µµÂøÇÔ2");
			    String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String name = request.getParameter("name");
				String ssn = request.getParameter("ssn");
				String credit = request.getParameter("credit");
				
				param.setId(id);
				param.setPw(pw);
				param.setName(name);
				param.setSsn(ssn);
				param.setCredit(credit);
				System.out.println("È¸¿øÁ¤º¸ : "+ param.toString());
				service.join(param);
				//Receiver.cmd.setPage("login");
					break;
			 
			case "login" :
				System.out.println("MemberController¿¡ µµÂøÇÔ3");
			     id = request.getParameter("id");
				pw = request.getParameter("pw"); 
				param.setId(id);
				param.setPw(pw);
				param = service.login(param);
				request.setAttribute("customer", param);
				if(param == null) {
					System.out.println("null");
						Receiver.cmd.setPage("login");
				}else {
					System.out.println("nullÀÌ ¾Æ´Ô");
					Receiver.cmd.setPage("mypage");
				}
					break;
			 
					
			case "existId" : 
				break;
					
			default:
					break;
		}
		
		Sender.forward(request, response);
		}
		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

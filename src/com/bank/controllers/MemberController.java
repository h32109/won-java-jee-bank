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
import com.bank.command.LoginCommand;
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
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Receiver.init(request);
		try{Receiver.cmd.execute();}
		catch(Exception e) {
			e.printStackTrace();
		}
		Sender.forward(request, response);
		
		}
		

}

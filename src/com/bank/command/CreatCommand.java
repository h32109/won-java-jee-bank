package com.bank.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.domains.CustomerBean;
import com.bank.serviceimpls.MemberServiceImpl;
import com.bank.services.MemberService;

public class CreatCommand extends MoveCommand { 

		public CreatCommand(HttpServletRequest request)throws Exception {
			super(request);
		}
		
		@Override
		public void execute() {
	
		super.execute();
		CustomerBean param = new CustomerBean();
		MemberService service = new MemberServiceImpl();
		System.out.println("MemberController�� ������2");
		param.setId(request.getParameter("id"));
		param.setPw(request.getParameter("pw"));
		param.setName( request.getParameter("name"));
		param.setSsn(request.getParameter("ssn"));
		param.setCredit(request.getParameter("credit"));
		System.out.println("ȸ������ : "+ param.toString());
		service.join(param);
		Receiver.cmd.setPage("login");
		System.out.println("ȸ������ �� ������ ������ : " + Receiver.cmd.getView());
		}
	}



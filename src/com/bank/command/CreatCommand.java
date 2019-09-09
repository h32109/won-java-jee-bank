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
		System.out.println("MemberController에 도착함2");
		param.setId(request.getParameter("id"));
		param.setPw(request.getParameter("pw"));
		param.setName( request.getParameter("name"));
		param.setSsn(request.getParameter("ssn"));
		param.setCredit(request.getParameter("credit"));
		System.out.println("회원정보 : "+ param.toString());
		service.join(param);
		Receiver.cmd.setPage("login");
		System.out.println("회원가입 후 가야할 페이지 : " + Receiver.cmd.getView());
		}
	}



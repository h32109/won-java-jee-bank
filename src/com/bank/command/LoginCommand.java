package com.bank.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.domains.CustomerBean;
import com.bank.serviceimpls.MemberServiceImpl;
import com.bank.services.MemberService;

public class LoginCommand extends MoveCommand {
	public LoginCommand(HttpServletRequest request)throws Exception {
		super(request);
	}
	@Override
	public void execute() {
		CustomerBean param =new CustomerBean();
		MemberService service = new MemberServiceImpl();
		System.out.println("MemberController�� ������3");
		param.setId( request.getParameter("id"));
		param.setPw(request.getParameter("pw"));
		CustomerBean cust = service.login(param);
		String domain ="";
		String page  ="";
		if(cust ==null) {
			
				page = "login";
				domain ="customer";
		}else {
			System.out.println("null�� �ƴ�");
			     page = "mypage";
			     domain ="customer";
		}
		
		Receiver.cmd.setPage(page);
		Receiver.cmd.setDomain(domain);
		Receiver.cmd.setView(domain, page);
		request.setAttribute("customer", cust);
		
		System.out.println("�ٺ�! :"+Receiver.cmd.getView());
	}
	
}

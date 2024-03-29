package com.bank.command;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command {
	public MoveCommand(HttpServletRequest request) throws Exception {
		setRequest(request);
		setDomain(domain);
		setAction(request.getParameter("action")==null? "move" :
			request.getParameter("action"));
	}
	
	public void execute(){
		setRequest(request);
		super.execute();
		request.setAttribute("page", request.getParameter("page"));
	}
}

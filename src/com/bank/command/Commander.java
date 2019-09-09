package com.bank.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.enums.Action;

public class Commander  {

	public static Command order(HttpServletRequest request) {
		Command cmd = new Command();
		String action = "";
		if(request.getParameter("action")==null) {
					action = "MOVE";
				}else {
					action = Action.valueOf(
							request.getParameter("action")
							.toUpperCase()).toString();
				}
		try {
		switch(Action.valueOf(action)) {
		case MOVE :
			cmd = new MoveCommand(request);
			break;
		case LOGIN :
			cmd = new LoginCommand(request);
			 break;
		case JOIN :
			cmd = new CreatCommand(request);
			break;
		default:
			break;
		
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cmd;
	}

	
}

package com.bank.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sender {
	public static void forward(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("캐리어내부:"+Receiver.cmd.getView());
		System.out.println("센더입니다."+request.getParameter("page"));
		try {
			request.getRequestDispatcher(Receiver.cmd.getView())
			.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

}
}

package com.bank.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sender {
	public static void forward(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ĳ�����:"+Receiver.cmd.getView());
		System.out.println("�����Դϴ�."+request.getParameter("page"));
		try {
			request.getRequestDispatcher(Receiver.cmd.getView())
			.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

}
}

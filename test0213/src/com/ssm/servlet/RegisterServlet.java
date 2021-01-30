package com.ssm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssm.annotation.AnnotationTest;
import com.ssm.mybatis.mybatis;
import com.user.User;



//註冊時使用
@WebServlet("/com/userregister")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	mybatis mybatis;
	AnnotationTest ant;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("texl/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		User user=new User();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String idcard=request.getParameter("id");
		
		
		user.setName(name);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		user.setIdCard(idcard);
		
		boolean flag=ant.mytest1(user);
//		UserDao dao=new UserDaoimpl();
		//呼叫登入系統 boolean 判斷登入成功前往成功的jsp
		//失敗前往失敗的jsp
		if(flag) {
			request.setAttribute("info", name);
			request.getRequestDispatcher("/index/register_success.jsp")
			.forward(request,response);
		}else {
			request.setAttribute("info",name);
			request.getRequestDispatcher("/index/register_error.jsp")
			.forward(request, response);
		}

	}

}

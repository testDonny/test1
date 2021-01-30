package com.ssm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.dao.UserDao;
import com.user.User;

@WebServlet("/com/updeteequals")
public class updateequals extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public updateequals() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("texl/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		User user=new User();
		if((String)request.getSession().getAttribute("name")==null&&(String)request.getSession().getAttribute("idcard")==null) {
			response.sendRedirect(request.getContextPath()+"/index/login_erroer");
		}else {
		user.setName((String)request.getSession().getAttribute("name"));
		user.setIdCard((String)request.getSession().getAttribute("idcard"));
		user.setPassword(request.getParameter("password"));
		
		ApplicationContext applicationContext=
		new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao=(UserDao)applicationContext.getBean("userDao");
		PrintWriter out=response.getWriter();
		boolean flag=userDao.updatenameandidcard(user);
		
		if(flag==true) {
			request.getRequestDispatcher("/index/updatesuccess.jsp").forward(request, response);
		}else {
			System.out.println("­×§ï¥¢±Ñ");
		}
		}

	}

}

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

@WebServlet("/com/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public update() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("texl/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		if(request.getParameter("name")==null&&request.getParameter("password")==null) {
			response.sendRedirect(request.getContextPath()+"/index/login_erroer");
		}else {
		User user=new User();
		request.getSession().setAttribute("name", request.getParameter("name"));
		request.getSession().setAttribute("idcard",request.getParameter("idcard"));
		user.setName(request.getParameter("name"));
		user.setIdCard(request.getParameter("idcard"));
		ApplicationContext applicationContext=
		new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao=(UserDao)applicationContext.getBean("userDao");
		user=userDao.updateselect(user);
		
		if(user==null) {
		response.sendRedirect(request.getContextPath()+"/index/update_error.jsp");
		}else {
			boolean flag=userDao.updatenameandidcard(user);
				if(flag) {
			request.getSession().setAttribute("name",request.getParameter("name"));
			request.getSession().setAttribute("idcard",request.getParameter("idcard"));
			request.getRequestDispatcher("/index/updatesuccess_password.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/index/updateerror.jsp").forward(request, response);	
			}
		}
	}
}

}

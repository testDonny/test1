package com.ssm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.annotation.AnnotationTest;
import com.ssm.card.management;
import com.ssm.dao.UserDao;
import com.ssm.mybatis.mybatis;
import com.user.User;




@WebServlet("/com/servlet")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public servlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("texl/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		try {

		management m= new management();

		User user=(User)request.getSession().getAttribute("user");
		ApplicationContext applicationContext=
		new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao=(UserDao)applicationContext.getBean("userDao");
		m=userDao.card(user.getName(),user.getPassword());
		request.setAttribute("cardTotal",m.getUR()+m.getSSR()+m.getSR()
		+m.getR()+m.getN());
		request.getRequestDispatcher("/index/card.jsp").forward(request,response);
		if((User)request.getSession().getAttribute("user")==null) {
		response.sendRedirect(request.getContextPath()+"/index/login_error.jsp");
		}
		}catch(NullPointerException e) {//沒登入的情況下不想看到NullPointerException
		response.sendRedirect(request.getContextPath()+"/index/login_error.jsp");
		}

}

}

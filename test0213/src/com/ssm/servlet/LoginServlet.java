package com.ssm.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.mybatis.mybatis;
import com.user.User;
import com.ssm.annotation.AnnotationTest;
import com.ssm.card.management;
import com.ssm.dao.UserDao;
//登入成功時使用
@WebServlet(urlPatterns="/com/userlogin",
initParams={@WebInitParam(name ="contextConfigLocation",
value ="classpath:applicationContext.xml")})
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID=1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	
	}
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		response.setContentType("texl/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String autologin = request.getParameter("autologin");
		System.out.println("servletloginname=  "+name);
		System.out.println("servletloginpassword=  "+password);
		User user=new User();
		user.setName(name);
		user.setPassword(password);

		ApplicationContext applicationContext=
		new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao=(UserDao)applicationContext.getBean("userDao");
		user=userDao.login(name, password);

		if(user==null){
			response.sendRedirect(request.getContextPath()+"/index/login_error.jsp");
		}else {
			Cookie cookie=new Cookie("user",user.getName()+"&"+user.getPassword());
			cookie.setPath("/");
			if(autologin==null) {
			cookie.setMaxAge(0);//不點選登入狀態cookie產生時間為0
			
			}else {
				cookie.setMaxAge(3600*24);//持續1天
				System.out.println("產生cookie持續一天");
			}
			response.addCookie(cookie);//產生cookie
			System.out.println("產生cookie");
			session.setAttribute("user", user);//設定生命週期為session的變數名稱為user
			System.out.println("usertest=  "+session.getAttribute("user"));
			
			String url ="/index/start.jsp";
			request.getRequestDispatcher(url)
			.forward(request, response);
		}
		
	}


}

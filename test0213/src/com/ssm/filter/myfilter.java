package com.ssm.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.dao.UserDao;
import com.user.User;


//@WebFilter(urlPatterns="/*",initParams={@WebInitParam(name="autologin",value="login")})
public class myfilter implements Filter {
	private FilterConfig filterConfig;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		String uri = req.getRequestURI();
		String contextPath=req.getContextPath();//請求路徑
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		
		uri=uri.substring(contextPath.length()+1);
	
		System.out.println("filtername= "+req.getSession().getAttribute("user"));
		String login=filterConfig.getInitParameter("autologin");
		System.out.println("直接通行的路徑"+login);
		System.out.println("uri測試="+uri.contains(login));
		HttpSession session=req.getSession();

			if(uri.contains(login)==false){
				User u=(User)session.getAttribute("user");
				System.out.println("sessionUser="+session.getAttribute("user"));
				if(u!=null) {
				System.out.println("session不為null");
				chain.doFilter(request, response);
				}else {
				String name = "";
				String password = "";
				Cookie[] cookies =req.getCookies();
				for(int x=0;cookies!=null&&x<cookies.length;x++) {
					if("user".equals(cookies[x].getName())) {
					String string = cookies[x].getValue();
					String[] values = string.split("&");
					name = values[0];		//{name,value}
					password = values[1];	//{password,value}
					System.out.println("cookietestname="+name);
					System.out.println("cookietestpasswordname="+password);
					ApplicationContext applicationContext=
							new ClassPathXmlApplicationContext("applicationContext.xml");
					UserDao userDao=(UserDao)applicationContext.getBean("userDao");
					User user=userDao.login(name, password);
					System.out.println("user= "+user);
					if(user!=null) {
					System.out.println("自動登入了");
					req.getSession().setAttribute("user",user);
		
					}
				}
			}
				chain.doFilter(request, response);
			}
				
		}	
		else {
			chain.doFilter(request, response);
		}
		}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig=filterConfig;
	}

}

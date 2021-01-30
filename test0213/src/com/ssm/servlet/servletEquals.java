package com.ssm.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.annotation.AnnotationTest;
import com.ssm.card.management;
import com.ssm.dao.UserDao;
import com.ssm.mybatis.mybatis;
import com.user.User;



@WebServlet("/com/servletEquals")
public class servletEquals extends HttpServlet {
	private static final long serialVersionUID = 1L;
	management m=new management();

    public servletEquals() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		this.doPost(request, response);
	}

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("texl/html charset=utf-8");
		response.setCharacterEncoding("utf-8");
		try {
		String card=request.getParameter("card");

		management m= new management();
		User user=(User)request.getSession().getAttribute("user");

		ApplicationContext applicationContext=
		new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao=(UserDao)applicationContext.getBean("userDao");
	
		List list =new ArrayList();	
		if(card.equals("one")){
		System.out.println("one");
		m=userDao.card(user.getName(),user.getPassword());
		request.setAttribute("a1",m.test(m.getOne()));
		request.setAttribute("cardTotal",m.getUR()+m.getSSR()+m.getSR()
		+m.getR()+m.getN());
		User users=userDao.update(m, user.getName(), user.getPassword()) ;
		}else if(card.equals("ten")) {
		m=userDao.card(user.getName(),user.getPassword());
			for(int x=0;x<=9;x++) {
		if(x%2!=0) {
		list.add(m.test(m.getOne())+"<br>");
		}else {
			list.add(m.test(m.getOne()));
		}
		}
		request.setAttribute("a1",list);
		request.setAttribute("cardTotal",m.getUR()+m.getSSR()+m.getSR()
		+m.getR()+m.getN());
		User users=userDao.update(m,user.getName(),user.getPassword()) ;
		}
		if((User)request.getSession().getAttribute("user")==null) {
		response.sendRedirect(request.getContextPath()+"/index/login_error.jsp");
		}else {
		String url="/com/servlet";
		request.getRequestDispatcher(url)
		.forward(request, response);
		}
		}catch(NullPointerException e) {//沒登入的情況下不想看到NullPointerException
	response.sendRedirect(request.getContextPath()+"/com/servlet");
		//我先在/com/servlet 產生抓獲目前剩餘的卡片
		//先建立完再來這裡
	}

		
	}
	
}

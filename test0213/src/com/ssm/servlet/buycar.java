//package com.ssm.servlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebServlet("/com/buycar")
//public class buycar extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//    public buycar() {
//        super();
//
//    }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		this.doPost(request, response);
//	}
//
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out=response.getWriter();
//		HttpSession session=request.getSession();
//		
//		HashMap<String,Integer> shopping=
//	   (HashMap<String,Integer>)session.getAttribute("shopping");
//		
//		if(shopping!=null&&shopping.size()>0) {
//			out.println("你購買的書籍有: "+"<br>");
//			for(String num:shopping.keySet()) {
//				out.println(num+":"+shopping.get(num)+"本<br>");
//			}
//		}else {
//			out.print("你還沒有購買任何書籍"+"<br>");
//		}
//	}

//}

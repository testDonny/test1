//package com.ssm.servlet;
//
//import java.io.IOException;
//import java.util.HashMap;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//
//@WebServlet("/com/buy")
//public class buy extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//    public buy() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		this.doPost(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//		response.setCharacterEncoding("UTF-8");
//
//						//裡面抓購物車的值
//		HashMap<String,Integer> shopping=(HashMap<String,Integer>)request.getSession().getAttribute("book");
//		if(shopping==null) {
//			shopping=new HashMap<String,Integer>();	//第一次是會空的
//		}
//		String[] bookNames=request.getParameterValues("book");
//		if(bookNames!=null&&bookNames.length>0) {
//			String bookName=null;
//			for(String booknum:bookNames) {
//				switch(booknum) {
//				case "1":
//					bookName="java";
//					break;
//				case "2":
//					bookName="web";
//					break;
//				case "3":
//					bookName="android";
//					break;
//				}
//				if(shopping.containsKey(bookName)) {
//					shopping.put(bookName,shopping.get(bookName)+1);
//				}else {
//					shopping.put(bookName,1);
//				}
//			}
//		}
//		request.getSession().setAttribute("shopping",shopping);
//		request.getRequestDispatcher("/com/buycar").forward(request,response);
//	}
//
//}

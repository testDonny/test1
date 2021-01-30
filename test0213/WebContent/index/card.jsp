<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class ="com.user.User" scope="request"/>
<%@page import="com.user.User" %>
<%@page import="com.ssm.dao.UserDao" %>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@page import="com.ssm.card.management" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jsq/jquery.min.js"></script>
	<script type="text/javascript">	
	<%
	management m= new management();
	user=(User)request.getSession().getAttribute("user");
	System.out.println("user= "+(User)request.getSession().getAttribute("user"));
	try{
	ApplicationContext applicationContext=
	new ClassPathXmlApplicationContext("applicationContext.xml");
	UserDao userDao=(UserDao)applicationContext.getBean("userDao");
	m=userDao.card(user.getName(),user.getPassword());
	
	
	request.setAttribute("card1",m.test2(m.getUR(),m.getSSR(),m.getSR(),m.getR(),m.getN()));
	request.setAttribute("card2",m.test1(m.getMyCardUR(),m.getMyCardSSR(),
			m.getMyCardSR(),m.getMyCardR(),m.getMyCardN()));
	request.setAttribute("cardTotal",m.getUR()+m.getSSR()+m.getSR()
	+m.getR()+m.getN());
	if(request.getSession().getAttribute("user")==null){
	response.sendRedirect(request.getContextPath()+"/index/login_error.jsp");
	}
	}catch(NullPointerException e){
		response.sendRedirect(request.getContextPath()+"/com/servlet");
	}
	%>
    window.onload=function(){
        var aImg=document.getElementsByTagName('img');
	
        function tick(){
            var oDate=new Date();
            var str=toDou(oDate.getHours())+toDou(oDate.getMinutes())+toDou(oDate.getSeconds());
        for( var i=0;i<aImg.length;i++){
            aImg[i].src='${pageContext.request.contextPath}/img/'+str[i]+'.png';
        }
 
     }
        setInterval(tick,1000);
        tick();
    };
	
	$(document).ready(function(){
		alert("測試jQuery能否使用");


		var card=${cardTotal};
		alert("目前剩餘卡片"+card);
		$("#form1").submit(function(){	
		if($("input[name=card]:checked").val()==null){
			$("#cardError").html("點選錯誤");
			alert("請點選抽卡方式");
			return false;
		}
		if(card<=9&&$("input[name=card]:checked").val()=="ten"){
			$("#cardError").html("卡池卡片不足請從新刷新");
			alert("卡池卡片不足請從新刷新");
			return false;
		}
		if(card==0){
			$("#cardError").html("卡池已規0請從新刷新");
			alert("卡池數量已歸零請從新刷新");
			return false;	
		}

		
	});
});
    function toDou(n){
    	if(n<10)
    	{
    	        return '0'+n;
    	}else{
    	    return ''+n;
    	}
    	    }

	</script>
            我是時間<img src="${pageContext.request.contextPath}/img/0.png"/>
            <img src="${pageContext.request.contextPath}/img/0.png"/>
            :
            <img src="${pageContext.request.contextPath}/img/0.png"/>
            <img src="${pageContext.request.contextPath}/img/0.png"/>
            :
            <img src="${pageContext.request.contextPath}/img/0.png"/>
            <img src="${pageContext.request.contextPath}/img/0.png"/>
</head>
<body style="background:black; color:white; font-size:30px;">

<h1>歡迎來到抽卡程式</h1>
<hr>
	<h3>您擁有的卡片&nbsp&nbsp&nbsp&nbsp卡池裡剩餘的卡片&nbsp&nbsp您獲得的卡片</h2>
	<table height="150px" width="800px" border="1px";>
	<tr>
	<td height="200px" width="400px"><%=request.getAttribute("card1") %></td>
	<td height="200px" width="400px"><%=request.getAttribute("card2") %></td>
	<td height="200px" width="500px">${a1}</td>
	</tr>
	</table>
	<br>
	<form action="${pageContext.request.contextPath}/com/servletEquals" method="post" id="form1">
	抽一次<input type="radio" name="card" value="one">
	抽十次<input type="radio" name="card" value="ten">
	<div id="cardError" style="display:inline;color:red;"></div>
	<br>

	<input type="submit" value="確定" >
	</form>
</body>
</html>
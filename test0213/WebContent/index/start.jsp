<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="com.user.User" %> 
<!DOCTYPE html>
<html>
<head>
<style>
body {background:black; color:white; font-size:30px;}
#div1 {height:200px; width:500;background:yellow;margin:50px auto;position:relative;}
#test {height:80px; width:120px; background:red; display:none; position:absolute;}
* {margin:0; padding:0;}      /*餘量0 填充0*/
#testpng {width:850px; height:170px; margin:20px auto; position:relative;     /*position:relative  位址 絕對*/
overflow:hidden;}  /*overflow:hidden 超出範圍的隱藏 *//*給4張圖的寬度 一張圖的高度     margin 跟上面的距離100px  auto 會自跟著放大縮小動改變*/
#testpng ul{position:absolute; left:0; top:0;}			/*不要看到節點*/
#testpng ul li{float:left; width:295px; height:170px; list-style:none;}
#showbox {float:right;}
</style>												
<script type="text/javascript">
window.onload=function(){
	ShowTime();
	var odiv=document.getElementById("aa");
    var test=document.getElementById("test");
    var testpng=document.getElementById('testpng');
    var testpngUl=testpng.getElementsByTagName("ul")[0];
    var testpngLi=testpngUl.getElementsByTagName("li");
    odiv.onmouseover=function(){
        test.style.display="block";
    }
    odiv.onmouseout=function(){
        test.style.display="none";
    }
    var speed=2;    //一開始先向右走
    testpngUl.innerHTML=testpngUl.innerHTML+testpngUl.innerHTML;//顯示兩個有限制長度多餘的會消失
    testpngUl.style.width=testpngLi[0].offsetWidth*testpngLi.length+'px';
						//ul的長度等於第一個li裡的圖片寬度*整個li的長度
    function move(){

    if(testpngUl.offsetLeft>0){
    testpngUl.style.left=-testpngUl.offsetWidth/2+'px';	
    }
    testpngUl.style.left=testpngUl.offsetLeft+speed+'px';
    
}
    var time=setInterval(move,50);

    testpng.onmouseover=function(){
        clearInterval(time);
    };
    testpng.onmouseout=function(){
        time=setInterval(move,50);
	};

};
function ShowTime(){
 var oDate=new Date();
 var str=(oDate.getHours())+"點"+(oDate.getMinutes())+"分"+(oDate.getSeconds())+"秒";
document.getElementById('showbox').innerHTML = str;
setTimeout('ShowTime()',1000);
}

</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

if((User)request.getSession().getAttribute("user")==null){
	response.sendRedirect(request.getContextPath()+"/index/login_error.jsp");
}
%>
<div id="showbox"></div>
<div id="testpng">
	<ul>
	<li><img src="${pageContext.request.contextPath}/img/test1.png"/></li>
	<li><img src="${pageContext.request.contextPath}/img/test2.png"/></li>
	<li><img src="${pageContext.request.contextPath}/img/test3.png"/></li>
	</ul>
</div>

<div id="div1">
	<ul>
		<li><a id="aa" href="${pageContext.request.contextPath}/com/servlet"
     target="_blank">來點我</a>
     	</li>
     	<li id="test">
     	我是抽卡程式
     	</li>
     	<!-- <li><a href="${pageContext.request.contextPath}/index/buy.jsp" target="_blank">點我</a> -->
     	</li>
     </ul>
    </div>
</body>
</html>
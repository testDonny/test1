<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>註冊頁面</title>
<style	type="text/css">
h1{text-align:center;}
h4{text-align:right;color:red;}
</style>
	<script type="text/javascript" src="jsq/jquery.min.js"></script>
	<script type="text/javascript">	
	$(document).ready(function(){
		alert("測試jQuery能否使用");

		$("#form1").submit(function(){
			var countTest=0;
			$("#nameError").html("");
			$("#PhoneError").html("");
			$("#passwordError").html("");
			$("#relpasswordError").html("");
			$("#EmailError").html("");
			$("#PhoneError").html("");
			$("#idError").html("");
			var test=[" ","$","%","#"];
			var name=$("#name").val();
			if(name.length==0||name.trim(name.length)==0){
				$("#nameError").html("帳號不能為空");
				countTest++;
			}
			var password=$("#password").val();
			if(password.length==0||password.trim(password.length)==0){
				$("#passwordError").html("密碼不能為空");
				countTest++;
			}
			var relpassword=$("#relpassword").val();
			if(relpassword.length==0||relpassword.trim(relpassword.length)==0){
				$("#relpasswordError").html("確認密碼不能為空");
				countTest++;
			}else if(password!=relpassword){
				$("#relpasswordError").html("確認密碼不正確,請從新輸入");
				countTest++;
			}
			
			var Email=$("#email").val();
			if(Email.length==0||Email.trim(Email.length)==0){
				$("#EmailError").html("信箱不可為空");
				countTest++;
			}
			var Phone=$("#phone").val();
			if(Phone.length!=10){
				$("#PhoneError").html("電話長度不正確");
				countTest++;
			}
			var phone=["0","1","2","3","4","5","6","7","8","9"];

			var count=0;
			for(var x=0;x<Phone.length+1;x++){
				if(count==10){
				$("#PhoneError").html("電話請輸入阿拉伯數字");
				countTest++;
				break;
			}
				count=0;
				for(var y=0;y<phone.length;y++){
				if(Phone[x]!=phone[y]){
				count++;
				}
			}
		}
		var first=["A","B","C","D","E","F","G","H","I","j"
				,"K","L","M","N","O","P","Q","R","S","T","U",
				"V","W","X","Y","Z"];
	
			var id=$("#id").val();
			if(id.length!=10){
				$("#idError").html("身分證長度錯誤");
				countTest++;
			}
			for(var x=0;x<first.length+1;x++){
				if(x==26){
					$("#idError").html("身分證字首錯誤");
					countTest++;
					break;
				}
				if(id[0]==first[x]){
				break;
				}
			}
			if(id[1]!=1&&id[1]!=2){
				$("#idError").html("身分證格式有誤");
				countTest++;
			}
		var Firstcalculation;
		switch(id[0]){
		case "A":Firstcalculation=10;break;
		case "B":Firstcalculation=11;break;
		case "C":Firstcalculation=12;break;
		case "D":Firstcalculation=13;break;
		case "E":Firstcalculation=14;break;
		case "F":Firstcalculation=15;break;
		case "G":Firstcalculation=16;break;
		case "H":Firstcalculation=17;break;
		case "I":Firstcalculation=34;break;
		case "J":Firstcalculation=18;break;
		case "K":Firstcalculation=19;break;
		case "L":Firstcalculation=20;break;
		case "M":Firstcalculation=21;break;
		case "N":Firstcalculation=22;break;
		case "O":Firstcalculation=35;break;
		case "P":Firstcalculation=23;break;
		case "Q":Firstcalculation=24;break;
		case "R":Firstcalculation=25;break;
		case "S":Firstcalculation=26;break;
		case "T":Firstcalculation=27;break;
		case "U":Firstcalculation=28;break;
		case "V":Firstcalculation=29;break;
		case "W":Firstcalculation=32;break;
		case "X":Firstcalculation=30;break;
		case "Y":Firstcalculation=31;break;
		case "Z":Firstcalculation=33;break;
		}
			var one=parseInt(Firstcalculation/10);
			var two=Firstcalculation%10;
			two=two*9;
			var total=parseInt(one)+parseInt(two)+parseInt(id[1])*8+parseInt(id[2])*7+parseInt(id[3])*6+
			parseInt(id[4])*5+parseInt(id[5])*4+parseInt(id[6])*3+parseInt(id[7])*2+parseInt(id[8])+parseInt(id[9]);
			alert(total);
			if(total%10!=0){
				$("#idError").html("身分證格式有誤");
				countTest++;
			}
			for(var x=0;x<name.length;x++){
				for(var i=0;i<test.length;i++){
					if(name[x]==test[i]){
					$("#nameError").html("帳號不可含有特殊符號");
					countTest++;
					}
				}
			}
			for(var x=0;x<password.length;x++){
				for(var i=0;i<test.length;i++){
					if(password[x]==test[i]){
					$("#relpasswordError").html("密碼不可含有特殊符號");
					countTest++;
					}
				}
			}
			if(countTest>0){
				return false;
			}
			
			
		});	
	});	
	</script>
</head>
<body>
	<form action="/com/userregister" method="post" id="form1">
		<h1>用戶註冊頁面</h1>
		<hr/>
		<table align="center">
			<tr>
				<td>帳&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;號:</td>
				<td>
					<input type="text" name="name" id="name"/>
					<div id="nameError" style="display:inline;color:red;"></div>
				</td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;碼;</td>
				<td>
					<input type="password" name="password" id="password">
					<div id="passwordError" style="display:inline;color:red;"></div>
				</td>
			</tr>
			<tr>
				<td>確認密碼:</td>
				<td>
					<input type="password"	name="relpassword" id="relpassword">
					<div id="relpasswordError" style="display:inline;color:red;"></div>
				</td>
			</tr>
			<tr>
			<td>
			身分證:
			</td>
			<td>
			<input type="text" name="id" id="id">
			<div id="idError" style="display:inline;color:red"></div>
			</td>
			</tr>
			<tr>
				<td>電話號碼:</td>
				<td><input type="text" name="phone" id="phone">
				<div id="PhoneError" style="display:inLine; color:red"></div></td>
			</tr>
			<tr>
				<td>電子郵件:</td>
				<td><input type="text" name="email" id="email">
				<div id="EmailError" style="display:inline; color:red;"></div>
				</td>
			</tr>
			<tr>
				<td colspan="1">
				</td>
				<td>
				<input type="submit" value="註冊"/>
				<input type="reset" value="重置"/>
			</td>
			</tr>						
		</table>
	</form>

	
</body>
</html>
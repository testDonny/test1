package com.user;

import com.ssm.card.management;

public class User {
private Integer id;
private String name;
private String password;
private String email;
private String phone;
private String idCard;
private management m=new management();


public management getM() {
	
	return m;
}
public void setM(management m) {
	this.m = m;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}

public String getIdCard() {
	return idCard;
}
public void setIdCard(String idCard) {
	this.idCard = idCard;
}
@Override
public String toString() {

	return "id= "+id+"name= "+name+"password= "+password+"email= "+email+
	"phone= "+phone+"myCardUR= "+m.getMyCardUR()+"myCardSSR= "+m.getMyCardSSR()+
	"myCardSR= "+m.getMyCardSR()+"myCardR= "+m.getMyCardR()+"myCardN= "+m.getMyCardN()+
	"UR= "+m.getUR()+"SSR= "+m.getSSR()+"SR= "+m.getSR()+"R= "+m.getR()+"N= "+m.getN();
}
public String toString1(int c1,int c2,int c3,int c4,int c5) {
	m=new management();
	return m.test1(c1,c2,c3,c4,c5);
}
public String toString2(int UR,int SSR,int SR,int R,int N) {
	m=new management();
	return m.test2(UR,SSR,SR,R,N);

}

}

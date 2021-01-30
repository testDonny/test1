package com.ssm.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.ssm.card.management;
import com.ssm.mybatis.mybatis;
import com.user.User;
@Repository

public class UserDaoImpl implements UserDao{
	@Override
	public User updateselect(User user) {
		SqlSession sqlSession=mybatis.getSession();
		User users=sqlSession.selectOne("com.ssm.mapper.UserMapper.updateselect",user);
		if(users==null) {
			System.out.println("代表帳號密碼不存在");
			return null;
		}else
			sqlSession.close();
			return users;
	}
	@Override
	public boolean updatenameandidcard(User user) {
		boolean flag=false;
		SqlSession sqlSession=mybatis.getSession();
		int users=sqlSession.update("com.ssm.mapper.UserMapper.updatenameandidcard",user);
		if(users>0) {
			sqlSession.commit();
			sqlSession.close();
			return flag=true;
			
		}else { 
			
		return flag;
		}
	}

	@Override
		public  User login(String name,String password) {
		User users=new User();
		management m=new management();
		users.setName(name);
		users.setPassword(password);
		users.getM().setUR(m.getUR());
		System.out.println("UR"+users.getM().getUR());
		SqlSession sqlSession=mybatis.getSession();
		User user=sqlSession.selectOne("com.ssm.mapper.UserMapper.findUser1",users);
		System.out.println(m);
		sqlSession.close();
		return user;
	}
	
	@Override
	public  management card(String name,String password) {
	User users=new User();
	management m=new management();
	users.setName(name);
	users.setPassword(password);
	users.getM().setUR(m.getUR());
	System.out.println("UR"+users.getM().getUR());
	SqlSession sqlSession=mybatis.getSession();
	m=sqlSession.selectOne("com.ssm.mapper.UserMapper.findUser",users);
	System.out.println(m);
	sqlSession.close();
	return m;
}

	@Override
	public boolean add(User user) {
		boolean flag=false;
//		ArrayList<Object> list=new ArrayList<Object>();
//		list.add(user.getName());
//		list.add(user.getPassword());
//		list.add(user.getEmail());
//		list.add(user.getPhone());
//		list.add(user.getIdCard());
//		management m=new management();
//		for(int x=0;x<m.getMyCard().length;x++) {
//		list.add(m.getMyCard()[x]);
//		}
//		list.add(m.getUR());
//		list.add(m.getSSR());
//		list.add(m.getSR());
//		list.add(m.getR());
//		list.add(m.getN());

		SqlSession sqlSession=mybatis.getSession();
		User users=sqlSession.selectOne("com.ssm.mapper.UserMapper.findName",user.getName());
		System.out.println("users="+users);
		if(users==null) {
			flag=true;
			users=sqlSession.selectOne("com.ssm.mapper.UserMapper.findIdCard",user.getIdCard());
			System.out.println("users="+users);
			if(users==null) {
				flag=true;
				int num1=sqlSession.insert("com.ssm.mapper.UserMapper.addUser",user);
				
				if(num1>0) {
				flag=true;
				}else
				flag=false;
				sqlSession.commit();
				sqlSession.close();
				
			}else {
				flag=false;
			}
		}else {
			flag=false;
		}
		

		return flag;
	}

	@Override
	public User update(management m, String name, String password) {
		User user=new User();
		user.setName(name);
		user.setPassword(password);
//		user.setM(m);
		user.getM().setUR(m.getUR());
		user.getM().setSSR(m.getSSR());
		user.getM().setSR(m.getSR());
		user.getM().setR(m.getR());
		user.getM().setN(m.getN());
		user.getM().setMyCardUR(m.getMyCardUR());
		user.getM().setMyCardSSR(m.getMyCardSSR());
		user.getM().setMyCardSR(m.getMyCardSR());
		user.getM().setMyCardR(m.getMyCardR());
		user.getM().setMyCardN(m.getMyCardN());
		SqlSession sqlSession=mybatis.getSession();
//		m=sqlSession.selectOne("com.ssm.mapper.UserMapper.findUser",user);
		int num=sqlSession.update("com.ssm.mapper.UserMapper.update",user);
		System.out.println("測試成功");
		sqlSession.commit();
		sqlSession.close();
		return user;
	}








}

package com.ssm.mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class mybatis {
	private static SqlSessionFactory sqlSessionFactory=null;
	static{
		try {
	String resource="mybatis-config.xml";
	InputStream inputStream=Resources.getResourceAsStream(resource);
	sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
}

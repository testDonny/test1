package com.ssm.annotation;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.card.management;
import com.ssm.dao.UserDao;
import com.user.User;

public class AnnotationTest {
	private static ApplicationContext applicationContext;

	public static boolean mytest1(User user) {
		applicationContext=
		new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao=(UserDao)applicationContext.getBean("userDao");
		if(userDao.add(user)) {
			return true;
		}else {
			return false;
		}
	}
}

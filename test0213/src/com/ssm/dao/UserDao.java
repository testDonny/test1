package com.ssm.dao;
import org.apache.ibatis.annotations.Param;

import com.ssm.card.management;
import com.user.User;
public interface UserDao {
		public User login(@Param("name")String name,@Param("password")String password);
		//單純查詢功能
		public boolean add(User user);
		//剩餘的新增修改刪除
		public User update(management m, String name, String password);
		public management card(String name, String password);
		public User updateselect(User user);
		boolean updatenameandidcard(User user);
;
}

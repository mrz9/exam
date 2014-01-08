package com.exam.dao;

import com.exam.model.User;

public interface UserDao {
	//添加用户
	public boolean addUser(User user);
	
	//删除用户
	public boolean delete(String uid);
	
	//根据用户id获取user
	public User getUserByUserId(String userid);
	
}

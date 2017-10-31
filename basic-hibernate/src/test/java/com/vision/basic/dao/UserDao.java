package com.vision.basic.dao;



import org.springframework.stereotype.Repository;

import com.vision.basic.model.User;




@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {
	
	

}

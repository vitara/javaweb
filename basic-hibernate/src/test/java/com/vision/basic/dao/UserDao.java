package com.vision.basic.dao;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.vision.basic.model.Pager;
import com.vision.basic.model.User;




@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {

	@Override
	public List<User> listUserBySql(String string, Object[] objects, Class<User> class1, boolean b) {
		// TODO Auto-generated method stub
		return super.listBySql(string, objects, class1, b);
	}

	@Override
	public List<User> listUserBySql(String string, Object[] objects, Map<String, Object> alias, Class<User> class1,
			boolean b) {
		// TODO Auto-generated method stub
		return super.listBySql(string, objects,alias,class1, b);
	}

	@Override
	public Pager<User> findUserBySql(String string, Object[] objects, Class<User> class1, boolean b) {
		// TODO Auto-generated method stub
		return super.findBySql(string, objects, class1, b);
	}

	@Override
	public Pager<User> findUserBySql(String string, Object[] objects, Map<String, Object> alias, Class<User> class1,
			boolean b) {
		
		return super.findBySql(string, objects, alias, class1, b);
	}
	
	

}

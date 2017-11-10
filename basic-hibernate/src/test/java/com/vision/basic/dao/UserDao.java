package com.vision.basic.dao;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.vision.basic.model.Pager;
import com.vision.basic.model.User;




@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {

	@Override
	public List<User> listBySql(String string, Object[] objects, Class<User> class1, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listBySql(String string, Object[] objects, Map<String, Object> alias, Class<User> class1,
			boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<User> findBySql(String string, Object[] objects, Class<User> class1, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<User> findBySql(String string, Object[] objects, Map<String, Object> alias, Class<User> class1,
			boolean b) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

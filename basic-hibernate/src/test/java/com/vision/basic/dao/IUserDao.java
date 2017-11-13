package com.vision.basic.dao;

import java.util.List;
import java.util.Map;

import com.vision.basic.model.Pager;
import com.vision.basic.model.User;

public interface IUserDao extends IBaseDao<User> {


	Pager<User> find(String string, Object[] objects, Map<String, Object> alias);

	List<User> listUserBySql(String string, Object[] objects, Class<User> class1, boolean b);

	List<User> listUserBySql(String string, Object[] objects, Map<String, Object> alias, Class<User> class1, boolean b);

	Pager<User> findUserBySql(String string, Object[] objects, Class<User> class1, boolean b);

	Pager<User> findUserBySql(String string, Object[] objects, Map<String, Object> alias, Class<User> class1, boolean b);

	Pager<User> find(String string, Object[] objects);

	List<User> list(String string, Object[] objects);

	List<User> list(String string, Object[] objects, Map<String, Object> alias);
	
}

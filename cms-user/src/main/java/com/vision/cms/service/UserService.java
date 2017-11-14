package com.vision.cms.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.vision.cms.dao.IGroupDao;
import com.vision.cms.dao.IRoleDao;
import com.vision.cms.dao.IUserDao;
import com.vision.cms.model.CmsException;
import com.vision.cms.model.Group;
import com.vision.cms.model.Role;
import com.vision.cms.model.User;

@Service("userService")
public class UserService implements IUserService {
	private IUserDao userDao;
	private IRoleDao roleDao;
	private IGroupDao groupDao;
	
	
	
	public IUserDao getUserDao() {
		return userDao;
	}
	@Inject
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	public IRoleDao getRoleDao() {
		return roleDao;
	}
	@Inject
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	public IGroupDao getGroupDao() {
		return groupDao;
	}
	@Inject
	public void setGroupDao(IGroupDao groupDao) {
		this.groupDao = groupDao;
	}

	@Override
	public void add(User user, Integer[] rids, Integer[] gids) {
		User tu=userDao.loadByUsername(user.getUsername());
		if(tu!=null) throw new CmsException("添加的用户对象已经存在，不能添加");
		userDao.add(user);
		for(Integer rid:rids){
			Role role=roleDao.load(rid);
			if(role==null) throw new CmsException("要添加的角色不存在");
			
		}
	}

	@Override
	public void delete(int id) {
		

	}

	@Override
	public void update(User user, Integer[] rids, Integer[] gids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStatus(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void findUser() {
		// TODO Auto-generated method stub

	}

	@Override
	public User load(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> listUserRoles(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> listUserGroups(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

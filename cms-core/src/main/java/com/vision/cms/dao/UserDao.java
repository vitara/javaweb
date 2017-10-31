package com.vision.cms.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.vision.basic.dao.BaseDao;
import com.vision.basic.model.Pager;
import com.vision.cms.model.Group;
import com.vision.cms.model.Role;
import com.vision.cms.model.RoleType;
import com.vision.cms.model.User;
import com.vision.cms.model.UserGroup;
import com.vision.cms.model.UserRole;

@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {


	public List<Role> listUserRoles(int userId) {
		String hql = "select ur.role from UserRole ur where ur.user.id=?";
		return this.getSession().createQuery(hql).setParameter(0,userId).list();
	}

	public List<Integer> listUserRoleIds(int userId) {
		String hql = "select ur.role.id from UserRole ur where ur.user.id=?";
		return this.getSession().createQuery(hql).setParameter(0,userId).list();
	}

	public List<Group> listUserGroups(int userId) {
		String hql = "select ug.group from UserGroup ug where ug.user.id=?";
		return this.getSession().createQuery(hql).setParameter(0, userId).list();
	}

	public List<Integer> listUserGroupIds(int userId) {
		String hql = "select ug.group.id from UserGroup ug where ug.user.id=?";
		return this.getSession().createQuery(hql).setParameter(0,userId).list();
	}

	public UserRole loadUserRole(int userId, int roleId) {
		String hql="select ur from UserRole ur where ur.user.id=? and ur.role.id=?";
		return (UserRole)this.getSession().createQuery(hql).setParameter(0, userId)
				.setParameter(1, roleId).uniqueResult();
	}

	public UserGroup loadUserGroup(int userId, int groupId) {
		String hql="select ug from UserGroup ug where ug.user.id=? and ug.group.id=?";
		return (UserGroup)this.getSession().createQuery(hql).setParameter(0, userId)
				.setParameter(1, groupId).uniqueResult();
	}

	public User loadByUsername(String username) {
		String hql="from User where username=?";
		return (User)this.queryObject(hql,username);
	}

	public List<User> listRoleUsers(int roleId) {
		String hql="select ur.user from UserRole ur where ur.role.id=?";
		return this.list(hql,roleId);
	}

	public List<User> listRoleUsers(RoleType roleType) {
		String hql="select ur.user from UserRole ur where ur.role.roleType=?";
		return this.list(hql,roleType);
	}

	public List<User> listGroupUsers(int gid) {
		String hql="select ug.user from UserGroup ug where ug.role.id=?";
		return this.list(hql,gid);
	}

}

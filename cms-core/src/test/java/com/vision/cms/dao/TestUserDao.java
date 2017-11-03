package com.vision.cms.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.vision.basic.model.Pager;
import com.vision.basic.model.SystemContext;
import com.vision.basic.test.util.AbstractDbUnitTestCase;
import com.vision.basic.test.util.EntitiesHelper;
import com.vision.cms.model.Group;
import com.vision.cms.model.Role;
import com.vision.cms.model.RoleType;
import com.vision.cms.model.User;
import com.vision.cms.model.UserGroup;
import com.vision.cms.model.UserRole;





@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestUserDao extends AbstractDbUnitTestCase{
	@Inject
	private IUserDao userDao;
	@Inject
	private SessionFactory sessionFactory;
	
	@Before
	public void setUp() throws SQLException, IOException, DatabaseUnitException {
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
		this.backupAllTable();
		IDataSet ds = createDateSet("t_user");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon,ds);
	}
	
	@Test
	public void testListUserRoles() throws DatabaseUnitException, SQLException{
		List<Role> actuals = Arrays.asList(new Role(2,"文章发布人员",RoleType.ROLE_PUBLISH),new Role(3,"文章审核人员",RoleType.ROLE_AUDIT));
		List<Role> roles = userDao.listUserRoles(2);
		EntitiesHelper.assertRoles(roles, actuals);
		
		
	}
	@Test
	public void testListUserRoleIds() throws DatabaseUnitException, SQLException {
		List<Integer> actuals = Arrays.asList(2,3);
		List<Integer> expected = userDao.listUserRoleIds(2);
		EntitiesHelper.assertObjects(expected, actuals);
	}
	
	@Test
	public void testListUserGroups() throws DatabaseUnitException, SQLException {
		List<Group> actuals = Arrays.asList(new Group(1,"财务处"),new Group(3,"宣传部"));
		List<Group> roles = userDao.listUserGroups(3);
		EntitiesHelper.assertGroups(roles, actuals);
	}
	
	@Test
	public void testListUserGroupIds() throws DatabaseUnitException, SQLException {
		List<Integer> actuals = Arrays.asList(1,3);
		List<Integer> expected = userDao.listUserGroupIds(3);
		EntitiesHelper.assertObjects(expected, actuals);
	}
	
	@Test
	public void testLoadUserRole() throws DatabaseUnitException, SQLException {
		int uid = 1;
		int rid = 1;
		UserRole ur = userDao.loadUserRole(uid, rid);
		User au = new User(1,"admin1","123","admin1","admin1@admin.com","110",1);
		Role ar = new Role(1,"管理员",RoleType.ROLE_ADMIN);
		EntitiesHelper.assertUser(ur.getUser(), au);
		EntitiesHelper.assertRole(ur.getRole(), ar);
	}
	
	@Test
	public void testLoadUserGroup() throws DatabaseUnitException, SQLException {
		int uid = 2;
		int gid = 1;
		UserGroup ug = userDao.loadUserGroup(uid, gid);
		User au = new User(2,"admin2","123","admin1","admin1@admin.com","110",1);
		Group ag = new Group(1,"财务处");
		EntitiesHelper.assertUser(ug.getUser(), au);
		EntitiesHelper.assertGroup(ug.getGroup(), ag);
	}
	
	@Test
	public void testLoadUserName() throws DatabaseUnitException, SQLException {
		User au = EntitiesHelper.getBaseUser();
		String username = "admin1";
		User eu = userDao.loadByUsername(username);
		EntitiesHelper.assertUser(eu, au);
	}
	
	@Test
	public void testListRoleUsers() throws DatabaseUnitException, SQLException {
		int rid = 2;
		List<User> aus = Arrays.asList(new User(2,"admin2","123","admin1","admin1@admin.com","110",1),
									   new User(3,"admin3","123","admin1","admin1@admin.com","110",1));
		List<User> eus = userDao.listRoleUsers(rid);
		EntitiesHelper.assertUsers(eus, aus);
	}
	
	@Test
	public void testListRoleUsersByRoleType() throws DatabaseUnitException, SQLException {
		List<User> aus = Arrays.asList(new User(2,"admin2","123","admin1","admin1@admin.com","110",1),
									   new User(3,"admin3","123","admin1","admin1@admin.com","110",1));
		List<User> eus = userDao.listRoleUsers(RoleType.ROLE_PUBLISH);
		EntitiesHelper.assertUsers(eus, aus);
	}
	
	@Test
	public void testListGroupUsers() throws DatabaseUnitException, SQLException {
		List<User> aus = Arrays.asList(new User(2,"admin2","123","admin1","admin1@admin.com","110",1),
				   new User(3,"admin3","123","admin1","admin1@admin.com","110",1));
		List<User> eus = userDao.listGroupUsers(1);
		EntitiesHelper.assertUsers(eus, aus);
	}
	
	
	
	@After
	public void tearDown() throws FileNotFoundException, DatabaseUnitException, SQLException{
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
		Session s = holder.getSession(); 
		s.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
		this.resumeTable();
	}
}

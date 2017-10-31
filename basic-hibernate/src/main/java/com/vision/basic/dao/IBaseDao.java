package com.vision.basic.dao;

import java.util.List;
import java.util.Map;

import com.vision.basic.model.Pager;

/**
 * 公共dao处理对象，这个对象包含hibernate基本和对SQL的操作
 * @author Alienware
 *
 * @param <T>
 */
public interface IBaseDao<T> {
	/**
	 * 添加对象
	 * @param t
	 * @return
	 */
	public T add(T t);
	/**
	 * 更新对象
	 * @param t
	 */
	public void update(T t);
	/**
	 * 根据id删除对象
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 根据id加载对象
	 * @param id
	 * @return
	 */
	public T load(int id);
	/**
	 * 不分页列表对象
	 * @param hql 查询对象的HQL
	 * @param args 查询参数
	 * @return 一组不分页的列表对象
	 */
	public List<T> list(String hql,Object[] args);
	public List<T> list(String hql,Object arg);
	public List<T> list(String hql);
	/**
	 * 基于别名和查询参数的混合列表
	 * @param hql
	 * @param args
	 * @param alias 别名对象
	 * @return
	 */
	public List<T> list(String hql,Object[] args,Map<String,Object> alias);
	public List<T> listByAlias(String hql,Map<String,Object> alias);
	
	/**
	 * 分页列表对象
	 * @param hql 查询对象的HQL
	 * @param args 查询参数
	 * @return 一组不分页的列表对象
	 */
	public Pager<T> find(String hql,Object[] args);
	public Pager<T> find(String hql,Object arg);
	public Pager<T> find(String hql);
	/**
	 * 基于别名和查询参数的混合列表
	 * @param hql
	 * @param args
	 * @param alias 别名对象
	 * @return
	 */
	public Pager<T> find(String hql,Object[] args,Map<String,Object> alias);
	public Pager<T> findByAlias(String hql,Map<String,Object> alias);
	/**
	 * 根据Hql查询一组对象
	 * @param hql
	 * @param args
	 * @return
	 */
	public Object queryObject(String hql,Object[] args);
	public Object queryObject(String hql,Object arg);
	public Object queryObject(String hql);
	public Object queryObject(String hql,Object[] args,Map<String,Object> alias);
	public Object queryObjectByAlias(String hql,Map<String,Object> alias);
	/**
	 * 根据HQL更新对象
	 * @param hql
	 * @param args
	 */
	public void updateByHql(String hql,Object[] args);
	public void updateByHql(String hql,Object arg);
	public void updateByHql(String hql);
	/**
	 * 根据SQL查询对象，不包含关联
	 * @param sql 查询的语句
	 * @param args 查询条件
	 * @param clz 查询实体对象
	 * @param hasEntity 该对象是否是hibernate所管理的实体，否则使用setResultTransform查询
	 * @return 一组对象
	 */
	public <N extends Object>List<N> listBySql(String sql,Object[] args,Class<?> clz,boolean hasEntity);
	public <N extends Object>List<N> listBySql(String sql,Object arg,Class<?> clz,boolean hasEntity);
	public <N extends Object>List<N> listBySql(String sql,Class<?> clz,boolean hasEntity);
	public <N extends Object>List<N> listBySql(String sql,Object[] args,Map<String,Object> alias,Class<?> clz,boolean hasEntity);
	public <N extends Object>List<N> listByAliasSql(String sql,Map<String,Object> alias,Class<?> clz,boolean hasEntity);
	/**
	 * 根据SQL查询对象，不包含关联
	 * @param sql 查询的语句
	 * @param args 查询条件
	 * @param clz 查询实体对象
	 * @param hasEntity 该对象是否是hibernate所管理的实体，否则使用setResultTransform查询
	 * @return 一组对象
	 */
	public <N extends Object>Pager<N> findBySql(String sql,Object[] args,Class<?> clz,boolean hasEntity);
	public <N extends Object>Pager<N> findBySql(String sql,Object arg,Class<?> clz,boolean hasEntity);
	public <N extends Object>Pager<N> findBySql(String sql,Class<?> clz,boolean hasEntity);
	public <N extends Object>Pager<N> findBySql(String sql,Object[] args,Map<String,Object> alias,Class<?> clz,boolean hasEntity);
	public <N extends Object>Pager<N> findByAliasSql(String sql,Map<String,Object> alias,Class<?> clz,boolean hasEntity);
	
}

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
	
	
}

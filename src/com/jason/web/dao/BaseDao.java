package com.jason.web.dao;

import java.io.Serializable;
import java.util.List;

import com.jason.web.utils.PaginationSupport;

public interface BaseDao<T extends Serializable, ID extends Serializable> {
	/**
	 * <strong>根据对象id获得�?个对�?</strong>
	 *
	 * @param id	对象主键id
	 *
	 * @return 返回�?个对象类�?
	 * */
	T getObjectById(ID id);
	
	/**
	 * <strong>根据HQL查询获得�?个对�?</strong>
	 *
	 * @param String	查询HQL	Object 可变参数列表
	 *
	 * @return 返回�?个对象类�?
	 * */
	T getObjectByHql(String hql, Object... params);
	
	/**
	 * <strong>根据SQL查询获得�?个对�?</strong>
	 *
	 * @param String	查询SQL	Object 可变参数列表
	 *
	 * @return 返回�?个对象类�?
	 * */
	T getObjectBySql(String sql, Object... params);
	
	/**
	 * <strong>保存�?条记�?</strong>
	 *
	 * @param entity �?个对象实�?
	 *
	 * @return 返回保存的对象实�?
	 * @throws Exception 
	 */
	T save(T entity) throws Exception;
	
	/**
	 * <strong>保存�?条新的记录或者跟新一条新的记�?</strong>
	 *
	 * @param entity �?个对象实�?
	 *
	 * @return 返回保存/更新的对象实�?
	 * @throws Exception 
	 */
	T saveOrUpdate(T entity) throws Exception;
	
	/**
	 * <strong>更新�?条记�?</strong>
	 *
	 * @param entity �?个对象实�?
	 *
	 * @return 返回更新的对象实�?
	 * @throws Exception 
	 */
	T update(T entity) throws Exception;
	
	/**
	 * <strong>删除�?个对象实�?</strong>
	 *
	 * @param entity 对象实体
	 * @throws Exception 
	 */
	void delete(T entity) throws Exception;
	
	/**
	 * <strong>通过ID删除�?个对�?</strong>
	 *
	 * @param ID 实体ID
	 */
	void deleteById(ID id) throws Exception;
	
	/**
	 * <strong>查询出所有的对象集合</strong>
	 *
	 * @return 返回�?个对象实体的集合
	 */
	List<T> findAll();
	
	/**
	 * <strong>根据HQL查询出所有的对象集合</strong>
	 *
	 * @param String	查询HQL	Object 可变参数列表
	 *
	 * @return 返回�?个对象实体的集合
	 */
	List<T> findListByHql(String hql, Object... params);
	
	/**
	 * <strong>根据SQL查询出所有的对象集合</strong>
	 *
	 * @param String	查询SQL	Object 可变参数列表
	 *
	 * @return 返回�?个对象实体的集合
	 */
	List<T> findListBySql(String sql, Object... params);
	
	/**
	 * <strong>分页查询出对象集�?</strong>
	 *
	 * @param String 查询语句
	 * @param int 页大�?
	 * @param int 查询页码（页�? �? 1�?
	 *
	 * @return 返回分页对象
	 */
	PaginationSupport findPageBySQLQuery(String hql, int pageSize, int currPage,Object... params);
	
	PaginationSupport findPageByQuery(final String hql, final int pageSize,
			final int currPage, final Object... params);
	
	Object queryUniqueResult(String hql);
	
}

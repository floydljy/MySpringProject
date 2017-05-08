package com.jason.web.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.jason.web.dao.BaseDao;
import com.jason.web.utils.PaginationSupport;



@Component("baseDao")
public class BaseDaoImpl<T extends Serializable, ID extends Serializable> implements BaseDao<T, ID> {

	private Logger logger=Logger.getLogger(this.getClass().getName());
	
	private Class<T> persistentClass = null;
	
	@SuppressWarnings("unchecked")
	protected Class<T> getPersistentClass() {
		if (this.persistentClass == null) {
			this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		}
		return this.persistentClass;
	}
	
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void delete(T entity) throws Exception {
		this.getCurrentSession().delete(entity);
	}
	
	public void deleteById(ID id) throws Exception{
		T t = this.getObjectById(id);
		this.delete(t);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {	
		List<T> list = sessionFactory.getCurrentSession()
				.createCriteria(this.getPersistentClass())
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public T getObjectById(ID id) {
		return (T) sessionFactory.getCurrentSession().get(this.getPersistentClass(),id);
	}

	public T save(T entity) throws Exception{
		sessionFactory.getCurrentSession().save(entity);
		return entity;
	}

	public T saveOrUpdate(T entity) throws Exception{
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		return entity;
	}

	public T update(T entity) throws Exception {
		this.getCurrentSession().update(entity);
		return entity;
	}

	public PaginationSupport findPageByQuery(final String hql, final int pageSize,
			final int currPage, final Object... params) {
		
		Query query = this.getCurrentSession().createQuery(hql.toString());
		if(params!=null){
			for(int i=0;i <params.length;i++){
				query.setParameter(i, params[i]);
			}
		}	
		int totalCount = query.list().size();
		int _pageSize = pageSize;
		int _currPage = currPage;
		if (pageSize <= 0) {
			_pageSize = Math.max(10, totalCount);
			_currPage = 1;
		}
		query.setFirstResult((_currPage - 1) * _pageSize);
		query.setMaxResults(_pageSize);
		List list = query.list();
		logger.debug("Page Query PageSize:" + _pageSize + " totalCount:" + totalCount);
		PaginationSupport pagination = new PaginationSupport(list, _pageSize, totalCount, _currPage);
		return pagination;		
	}
	
	@SuppressWarnings("rawtypes")
	public PaginationSupport findPageBySQLQuery(final String sql, final int pageSize,
			final int currPage, final Object... params) {	
				Query query = this.getCurrentSession().createSQLQuery(sql).addEntity(this.getPersistentClass());
				for(int i=0;i <params.length;i++){
					query.setParameter(i, params[i]);
				}
				int totalCount = query.list().size();
				int _pageSize = pageSize;
				int _currPage = currPage;
				if (pageSize <= 0) {
					_pageSize = Math.max(10, totalCount);
					_currPage = 1;
				}
				query.setFirstResult((_currPage - 1) * _pageSize);
				query.setMaxResults(_pageSize);
				List list = query.list();
				logger.debug("Page Query PageSize:" + _pageSize + " totalCount:" + totalCount);
				PaginationSupport pagination = new PaginationSupport(list, _pageSize, totalCount, _currPage);
				return pagination;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T getObjectByHql(String hql, Object... params) {
		
		Query query = this.getCurrentSession().createQuery(hql);
		for(int i=0; i<params.length; i++){
			query.setParameter(i, params[i]);
		}
		List list = query.list();
		if(list == null || list.size() == 0){
			return null;
		}else{
			return (T) list.get(0);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T getObjectBySql(String sql, Object... params) {
		
		Query query = this.getCurrentSession().createSQLQuery(sql)
					.addEntity(this.getPersistentClass());
		for(int i=0; i<params.length; i++){
			query.setParameter(i, params[i]);
		}
		List list = query.list();
		if(list == null || list.size() == 0){
			return null;
		}else{
			return (T) list.get(0);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findListByHql(String hql, Object... params) {
		
		Query query = this.getCurrentSession().createQuery(hql);
		for(int i=0; i<params.length; i++){
			query.setParameter(i, params[i]);
		}
		List list = query.list();
		if(list == null || list.size() == 0){
			return null;
		}else{
			return (List<T>) list;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findListBySql(String sql, Object... params) {
		
		Query query = this.getCurrentSession().createSQLQuery(sql)
					.addEntity(this.getPersistentClass());
		for(int i=0; i<params.length; i++){
			query.setParameter(i, params[i]);
		}
		List list = query.list();
		if(list == null || list.size() == 0){
			return null;
		}else{
			return (List<T>) list;
		}
	}

	public Object queryUniqueResult(String hql) {
		
		Query query=this.getCurrentSession().createQuery(hql);
		return query.uniqueResult();
	}
}

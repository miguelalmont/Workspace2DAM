package com.Unidad04.DAOImplHibernate;

import com.Unidad04.DAO.SeguroDAO;
import com.Unidad04.persistence.hibernate.util.GenericDAOImplHibernate;
import com.Unidad04.pojos.Seguro;

public class SeguroDAOImplHibernate extends GenericDAOImplHibernate<Seguro, Integer> implements SeguroDAO {
//	
//	SessionFactory sessionFactory;
//	
//	public SeguroDAOImplHibernate() {
//		sessionFactory = HibernateUtil.getSessionFactory();
//	}
//	
//	@Override
//	public Seguro create() throws Exception {
//		return getEntityClass().newInstance();
//	}
//
//	@Override
//	public void saveOrUpdate(Seguro seguro) throws BussinessException {
//		Session session = sessionFactory.getCurrentSession();
//		
//		session.beginTransaction();
//		session.saveOrUpdate(seguro);
//		session.getTransaction().commit();
//		
//	}
//
//	@Override
//	public Seguro get(Integer id) throws BussinessException {
//		Session session = sessionFactory.getCurrentSession();
//		
//		session.beginTransaction();
//		Seguro entity = (Seguro) session.get(getEntityClass(), id);
//		session.getTransaction().commit();
//
//		return entity;
//	}
//
//	@Override
//	public void delete(Integer id) throws BussinessException {
//		Session session = sessionFactory.getCurrentSession();
//		session.beginTransaction();
//		Seguro entity = (Seguro) session.get(getEntityClass(), id);
//		if (entity == null) {
//			throw new BussinessException(new BussinessMessage(null, "Los datos a borrar ya no existen"));
//		}
//		session.delete(entity);
//		session.getTransaction().commit();
//	}
//
//	@Override
//	public List<Seguro> findAll() throws BussinessException {
//		Session session = sessionFactory.getCurrentSession();
//		
//		Query query = session.createQuery("SELECT e FROM " + getEntityClass().getName() + " e");
//		List<Seguro> entities = query.list();
//
//		return entities;
//	}
//	
//	private Class<Seguro> getEntityClass() {
//		return (Class<Seguro>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//	}
}

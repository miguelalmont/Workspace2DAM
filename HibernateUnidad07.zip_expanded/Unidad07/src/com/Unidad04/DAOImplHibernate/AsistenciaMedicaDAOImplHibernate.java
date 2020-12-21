package com.Unidad04.DAOImplHibernate;

import com.Unidad04.DAO.AsistenciaMedicaDAO;
import com.Unidad04.persistence.hibernate.util.GenericDAOImplHibernate;
import com.Unidad04.pojos.AsistenciaMedica;

public class AsistenciaMedicaDAOImplHibernate extends GenericDAOImplHibernate<AsistenciaMedica,Integer> implements AsistenciaMedicaDAO {

//	SessionFactory sessionFactory;
//	
//	public AsistenciaMedicaDAOImplHibernate () {
//		sessionFactory = HibernateUtil.getSessionFactory();
//	}
//	
//	@Override
//	public AsistenciaMedica create() throws Exception {
//
//		return getEntityClass().newInstance();
//	}
//
//	@Override
//	public void saveOrUpdate(AsistenciaMedica asistenciaMedica) throws BussinessException {
//		Session session = sessionFactory.getCurrentSession();
//		
//		session.beginTransaction();
//		session.saveOrUpdate(asistenciaMedica);
//		session.getTransaction().commit();
//		
//	}
//
//	@Override
//	public AsistenciaMedica get(Integer id) throws BussinessException {
//		Session session = sessionFactory.getCurrentSession();
//		
//		session.beginTransaction();
//		AsistenciaMedica entity = (AsistenciaMedica) session.get(getEntityClass(), id);
//		session.getTransaction().commit();
//
//		return entity;
//	}
//
//	@Override
//	public void delete(Integer id) throws BussinessException {
//		Session session = sessionFactory.getCurrentSession();
//		session.beginTransaction();
//		AsistenciaMedica entity = (AsistenciaMedica) session.get(getEntityClass(), id);
//		if (entity == null) {
//			throw new BussinessException(new BussinessMessage(null, "Los datos a borrar ya no existen"));
//		}
//		session.delete(entity);
//		session.getTransaction().commit();		
//	}
//
//	@Override
//	public List<AsistenciaMedica> findAll() throws BussinessException {
//		Session session = sessionFactory.getCurrentSession();
//		
//		Query query = session.createQuery("SELECT e FROM " + getEntityClass().getName() + " e");
//		List<AsistenciaMedica> entities = query.list();
//
//		return entities;
//	}
//	
//	private Class<AsistenciaMedica> getEntityClass() {
//		return (Class<AsistenciaMedica>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//	}
}

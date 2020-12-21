package com.Unidad04.controllers;

import com.Unidad04.DAO.SeguroDAO;
import com.Unidad04.DAOImplHibernate.SeguroDAOImplHibernate;
import com.Unidad04.persistence.hibernate.util.BussinessException;
import com.Unidad04.pojos.Seguro;

public class SeguroController {
	
	SeguroDAO seguroDAO;
	
	public SeguroController() {
		seguroDAO = new SeguroDAOImplHibernate();
	}
	
	public void guardar(Seguro seguro) throws BussinessException {
		seguroDAO.saveOrUpdate(seguro);
	}
}

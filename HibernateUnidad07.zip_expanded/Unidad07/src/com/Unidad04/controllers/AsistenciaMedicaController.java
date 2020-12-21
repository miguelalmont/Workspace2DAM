package com.Unidad04.controllers;

import com.Unidad04.DAO.AsistenciaMedicaDAO;
import com.Unidad04.DAOImplHibernate.AsistenciaMedicaDAOImplHibernate;
import com.Unidad04.persistence.hibernate.util.BussinessException;
import com.Unidad04.pojos.AsistenciaMedica;

public class AsistenciaMedicaController {
	
	AsistenciaMedicaDAO asistenciaMedicaDAO;

	public AsistenciaMedicaController() {
		asistenciaMedicaDAO = new AsistenciaMedicaDAOImplHibernate();
	}

	public void guardar(AsistenciaMedica asistenciaMedica) throws BussinessException {
		asistenciaMedicaDAO.saveOrUpdate(asistenciaMedica);
	}
}

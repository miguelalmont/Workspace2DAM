package com.Unidad04.pojos;

import com.Unidad04.persistence.hibernate.util.*;

import java.util.Date;

import com.Unidad04.controllers.SeguroController;

enum Sexo {
	Hombre,
	Mujer
}


enum TipoAsistencia {
	Hospitalaria,
	Ambulatoria,
	CentroSalud,
	Domiciliaria
}

public class Main {

	public static void main(String[] args) throws Exception {

		HibernateUtil.buildSessionFactory();

		try {
			HibernateUtil.openSessionAndBindToThread();
			
			SeguroController seguroController = new SeguroController();
			
			Seguro seguro = new Seguro(new NIF("12345678N"), null, null, "Martínez", 31, Sexo.Mujer, true, 1, true, new Coberturas(true, true, true), new Enfermedades(false, true, false, true, "Acaros"), new Date());

			seguroController.guardar(seguro);

		} catch (BussinessException be) {
			System.out.println("No se ha podido guardar el alta de seguro.Se han producido los siguientes errores:");
			for (BussinessMessage bussinessMessage : be.getBussinessMessages()) {
				System.out.println(bussinessMessage.toString());
			}
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}

		HibernateUtil.closeSessionFactory();

	}

}

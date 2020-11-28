package com.objis.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.objis.spring.dao.IEmployeDao;

import domaine.Employe;

@Service("empService")
public class EmployeService {
	
	@Autowired
	@Qualifier("employeDaoTEMPLATE")
	private IEmployeDao dao;

	public IEmployeDao getDao() {
		return dao;
	}

	public void setDao(IEmployeDao dao) {
		this.dao = dao;
	}
	
	public void sauverEmploye(Employe employe) {
		dao.saveEmploye(employe);
	}
	
}

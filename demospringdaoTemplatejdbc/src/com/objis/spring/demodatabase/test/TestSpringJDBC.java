package com.objis.spring.demodatabase.test;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.objis.spring.demodatabase.dao.EmployeDao;
import com.objis.spring.demodatabase.dao.EmployeDao2;
import com.objis.spring.demodatabase.domaine.Employe;

public class TestSpringJDBC {

	private Employe emp;
	private EmployeDao dao;
	private EmployeDao2 dao2;
	private ClassPathXmlApplicationContext appContext;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("spring-data.xml");
		emp = new Employe(4, "morad", "mdpobjis", "Morad", "HANAFI", "morad.hanafi@objis.com", "employe");
		dao2 = (EmployeDao2)appContext.getBean("employeDao2"); // RECUPERATION DAO !!!
	}

	@After
	public void tearDown() throws Exception {
		emp = null;
		dao = null;
		appContext = null;
	}

	@Test
	public void testSaveEmploye() {
		//dao.saveEmploye(emp);
		dao2.saveEmploye(emp);
	}

	@Test
	public void testGetEmployeById() {
		//Employe employe = dao2.getEmployeById(2);
		Employe employe = dao2.getEmployeById(2);
		assertNotNull(employe);
	}
}

package com.objis.spring.demodatabase.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.objis.spring.dao.EmployeDao;
import com.objis.spring.domaine.Employe;

import junit.framework.TestCase;

public class TestSpringDAO extends TestCase {

	private Employe emp;
	private EmployeDao springDao;
	private ClassPathXmlApplicationContext appContext;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		emp = new Employe(48, "douglas", "mdpdoug", "Douglas", "MBIANDOU", "douglas.mbiandou@objis.com", "employe");
		appContext = new ClassPathXmlApplicationContext("spring-data.xml");

		springDao = (EmployeDao) appContext.getBean("employeDao");
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		emp = null;
		appContext = null;
		springDao = null;
	}

	public void testSaveEmploye() {
		springDao.save(emp);
	}
/*
	public void testFindOne() {
		Employe employe = springDao.findOne(1);
		assertNotNull(employe);
	}
*/	
	public void testFindByEmail() {
		List<Employe> employe = springDao.findByEmail(emp.getEmail());
		for(Employe e : employe) {
			System.out.println(e.getEmail());
		}
		assertNotNull(employe);
	}
}

package com.objis.spring.demodatabase.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.objis.spring.dao.IEmployeDao;
import com.objis.spring.dao.JdbcEmployeDao;
import com.objis.spring.dao.JdbcEmployeDaoSupport;

import domaine.Employe;
import junit.framework.TestCase;

public class TestSpringDAO extends TestCase {

private Employe emp ;
private IEmployeDao springDao ;
private ClassPathXmlApplicationContext appContext;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		emp = new Employe(51,"morad","mdpobjis","Morad","HANAFI","morad.hanafi@objis.com","employe");
		appContext = new ClassPathXmlApplicationContext("spring-data.xml");
		
		// Récupération du bean DAO 
		springDao = (IEmployeDao) appContext.getBean("employeDao"); 
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		emp = null;
		appContext = null;
		springDao = null;
	}

	public  void testSaveEmploye(){
		//Utilisation classe implémentant IEmployeDao (pas de classe concrète en dur)
		springDao.saveEmploye(emp); 
	}
	
	public void testGetEmployeById(){
		Employe employe = springDao.getEmployeById(2); 
		assertNotNull(employe);
	}
}

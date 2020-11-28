package com.objis.spring.demodatabase.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.objis.spring.dao.IEmployeDao;
import com.objis.spring.dao.JdbcEmployeDao;
import com.objis.spring.dao.JdbcEmployeDaoSupport;
import com.objis.spring.service.EmployeService;

import domaine.Employe;
import junit.framework.TestCase;

public class TestSpringService extends TestCase {

private Employe emp ;
private EmployeService employeService ;
private ClassPathXmlApplicationContext appContext;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		emp = new Employe(53,"morad","mdpobjis","Morad","HANAFI","morad.hanafi@objis.com","employe");
		appContext = new ClassPathXmlApplicationContext("spring-data.xml");
		
		// Récupération du bean DAO 
		employeService = (EmployeService) appContext.getBean("empService"); 
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		emp = null;
		appContext = null;
		employeService = null;
	}

	public  void testSauverEmploye(){
		//Utilisation classe implémentant IEmployeDao (pas de classe concrète en dur)
		employeService.sauverEmploye(emp); 
	}
	
}

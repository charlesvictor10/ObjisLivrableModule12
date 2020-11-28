package com.objis.spring.test;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.objis.spring.demo.SocieteDevLogiciel;

public class DemoApp {
	private static final Logger logger = Logger.getLogger(DemoApp.class);
	public static void main(String[] args) {
		// 1. Chargement du conteneur
		ApplicationContext appContext = (ApplicationContext) new ClassPathXmlApplicationContext("demo-beans.xml");
		// 2. Recupération du bean
		SocieteDevLogiciel societe = (SocieteDevLogiciel) appContext.getBean("SocieteDevLogiciel");
		// 3. Manipulation du bean
		logger.info("Chef Developpeur: "+societe.getChefDeveloppeur().getNom());
		logger.info("Développeur: "+societe.getDeveloppeur().getNom());
	}
}

package com.objis.spring.demo;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.objis.spring.demo.SocieteDevLogiciel;

public class DemoApp {

	private static final Logger logger = Logger.getLogger(DemoApp.class);

	public static void main(String[] args) {

		// 1. Chargement du conteneur en 4.0.0 Spring
		ApplicationContext appContext = (ApplicationContext) new ClassPathXmlApplicationContext("demo-beans.xml");

		// 2. Recuperation d'un bean du conteneur
		SocieteDevLogiciel societe = (SocieteDevLogiciel) appContext.getBean("societeDevLogiciel");

		// 3. Manipulation du bean avec injection de dependances
		logger.info("Chef Developpeur: " + societe.getChefDeveloppeur().getNom());
		logger.info("Developpeur     : " + societe.getDeveloppeur().getNom());
	}

}

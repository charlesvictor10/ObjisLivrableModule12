package com.objis.spring.demoinjection.test;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.objis.spring.demoinjection.Performeur;

public class DemoApp {

	private static final Logger logger = Logger.getLogger(DemoApp.class);

	public static void main(String[] args) {
		
		// 1. Chargement du conteneur
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spectacle.xml"));

		// 2. Recupération d'un bean
		Performeur musicien = (Performeur) beanFactory.getBean("olivier");

		// 3. Manipulation du bean
		musicien.performe();
		
		// 1. Chargement du conteneur
		ApplicationContext ctx = new FileSystemXmlApplicationContext("spectacle.xml");
		
		// 2. Recupération d'un bean
		Performeur musiciens = (Performeur) ctx.getBean("Louis");
		
		// 3. Manipulation du bean
		musiciens.performe();
	}
}

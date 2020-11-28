package fr.orsys.tp10.service;

import java.util.List;

import fr.orsys.tp10.domain.Employe;

public interface EmployeService {
	
	List<Employe> getAllEmployees();
	Employe getById(Long id);

}

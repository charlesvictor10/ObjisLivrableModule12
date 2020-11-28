package fr.orsys.tp10.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.orsys.tp10.dao.EmployeRepository;
import fr.orsys.tp10.domain.Employe;
import fr.orsys.tp10.service.EmployeService;

@Service
public class EmployeServiceImpl implements EmployeService {

	private EmployeRepository employeRepository;

	@Override
	public List<Employe> getAllEmployees() {
		return employeRepository.findAll();
	}


	@Override
	public Employe getById(Long id) {
		return employeRepository.findOne(id);
	}
	@Autowired
	public void setEmployeRepository(EmployeRepository employeRepository) {
		this.employeRepository = employeRepository;
	}

}

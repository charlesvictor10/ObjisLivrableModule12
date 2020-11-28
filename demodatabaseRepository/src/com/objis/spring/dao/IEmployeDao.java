package com.objis.spring.dao;

import java.util.List;

import domaine.Employe;

public interface IEmployeDao {
  public Employe getEmployeById(int id);
  public Employe getEmployeByLogin(String login);
  public void saveEmploye(Employe employe);
  public int getEmployesCount();
  public List<Employe> getAllEmployes();
  
}


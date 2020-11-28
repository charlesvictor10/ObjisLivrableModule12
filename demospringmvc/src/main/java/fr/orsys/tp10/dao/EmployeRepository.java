package fr.orsys.tp10.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.orsys.tp10.domain.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

}

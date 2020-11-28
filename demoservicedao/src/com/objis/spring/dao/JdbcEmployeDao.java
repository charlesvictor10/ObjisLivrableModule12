package com.objis.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import domaine.Employe;

@Repository("employeDaoTEMPLATE")
public class JdbcEmployeDao implements IEmployeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * Meilleure pratique utilisation JdbcTemplate : La datasource est injectée
	 * au DAO lors de la création de ce dernier . Paramétrage réalisé dans
	 * spring-data.xml
	 */

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void saveEmploye(Employe employe) {
		final String EMPLOYE_INSERT = "insert into employe (id,login, password, prenom, nom, email, role) "
			+ "values (?,?,?,?,?,?,?)";

        /*
	 * On récupère et on utilisera directement le jdbcTemplate
	 */
	jdbcTemplate.update(
			EMPLOYE_INSERT,
			new Object[] { employe.getId(),employe.getLogin(),employe.getPassword(), 
					employe.getPrenom(),employe.getNom(), employe.getEmail(),employe.getRole() });

	
	}

	/*
	 * Utilisation de Spring JdbcTemplate pour récupérer un Employe
	 * (non-Javadoc)
	 * 
	 * @see com.objis.dao.EmployeDao#findEmploye(long)
	 */
	public Employe getEmployeById(int id) {

		String sql = "select id, nom, prenom from employe where id = ?";

		// Mapping d'un enregistrement vers un ResultSet
		RowMapper mapper = new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employe employe = new Employe();
				employe.setId((int) rs.getLong("id"));
				employe.setNom(rs.getString("nom"));
				employe.setPrenom(rs.getString("prenom"));
				return employe;
			}

		};
		// Retourne l'objet Employe associé à l'Id
		// Notez 1) le casting explicite Employe,
		// 2) que l'enveloppe de l'argument 'id' dans un tableau d'objet,
		// 3) le boxing de 'id' comme un type reference Long
		// Ces étapes ne sont pas necessaire en utilisant (java 5)
		// SimpleJdbcTemplate
		return (Employe) jdbcTemplate.queryForObject(sql, new Object[] { Long
				.valueOf(id) }, mapper);
	}

	public List<Employe> getAllEmployes() {
		// TODO Auto-generated method stub
		return null;
	}

	public Employe getEmployeByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getEmployesCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
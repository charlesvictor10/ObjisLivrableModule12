package com.objis.spring.demodatabase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.objis.spring.demodatabase.domaine.Employe;

/*
 * EmployeDao avec DataSource injectée (injection par Setter). MAIS avec encore du code try/catch gestion d'exception 'Manuelle'
 */

public class EmployeDao {
	
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {  // NECESSAIRE pour l'Injection !!!
		this.dataSource = dataSource;
	}
	public void saveEmploye(Employe employe) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		try {
			final String EMPLOYE_INSERT =
				"insert into employe (id,login, password, prenom, nom, email, role) " +
				"values (?,?,?,?,?,?,?)";
	        conn = dataSource.getConnection();           // Via Injection !!!
			stmt = conn.prepareStatement(EMPLOYE_INSERT);
			stmt.setInt(1, employe.getId());
			stmt.setString(2, employe.getLogin());
			stmt.setString(3, employe.getPassword());
			stmt.setString(4, employe.getPrenom());
			stmt.setString(5, employe.getNom());
			stmt.setString(6, employe.getEmail());
			stmt.setString(7, employe.getRole());
			stmt.execute();
		} catch (SQLException e) {
		e.printStackTrace();
		} finally {
		try {
		if(stmt != null) { stmt.close(); }
		if(conn != null) { conn.close(); }
		} catch (SQLException e) {}
		}
		}
	/**
	 * Récupération Employe avec à partir de son id
	 */
	public Employe getEmployebyId(Integer id) {
		Connection conn = null;
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		try {
			final String EMPLOYE_QUERY =
				"select  id, login, email, password, prenom, nom, role " +
				" from employe where id=?";
	        conn = dataSource.getConnection();           // Via Injection !!!
			stmt = conn.prepareStatement(EMPLOYE_QUERY);			
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			Employe employe = null;
			if(rs.next()) {
			employe = new Employe();
			employe.setId(rs.getInt("id"));
			employe.setEmail(rs.getString("email"));
			employe.setPassword(rs.getString("password"));
			employe.setLogin(rs.getString("login"));
			employe.setNom(rs.getString("nom"));
			employe.setPrenom(rs.getString("prenom"));
			employe.setRole(rs.getString("role"));
			}
			return employe;
	
		} catch (SQLException e) {
		e.printStackTrace();
		} finally {
		try {
			if(rs != null) { rs.close(); }
		if(stmt != null) { stmt.close(); }
		if(conn != null) { conn.close(); }
		} catch (SQLException e) {}
		}
		return null;
		}

	
	public EmployeDao() {
		super();
	}
}

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Country;
import util.Conexion;

public class CountryDao {
	private Conexion conexion;
	
	private static final String INSERT_TEAM_SQL = "INSERT INTO country (name) VALUES (?,?);";
	private static final String DELETE_TEAM_SQL = "DELETE FROM country WHERE id = ?;";
	private static final String UPDATE_TEAM_SQL = "UPDATE country SET name = ?, country = ? WHERE id = ?;";
	private static final String SELECT_TEAM_BY_ID = "SELECT * FROM country WHERE id = ?;";
	private static final String SELECT_ALL_TEAMS = "SELECT * FROM country;";
	
	
	public CountryDao() {
		this.conexion = Conexion.getConexion();
	}
	
	public void insert (Country country) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_TEAM_SQL);
			preparedStatement.setString(1, country.getName());
			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	public void delete (int id) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(DELETE_TEAM_SQL);
			preparedStatement.setInt(1, id);
			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	public void update (Country country) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(UPDATE_TEAM_SQL);
			preparedStatement.setString(1, country.getName());
			preparedStatement.setInt(4, country.getId());
			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	public List<Country> selectAll() {
		List <Country> countrys = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_TEAMS);
			ResultSet rs =  conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				countrys.add(new Country(id, name));
			}
		} catch (SQLException e) {
			
		}
		
		return countrys;
	}
	
	public Country select(int id) {
		Country country = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_TEAM_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs =  conexion.query();
			
			while(rs.next()) {
				String name = rs.getString("name");
				country = new Country(id, name);
			}
		} catch (SQLException e) {
			
		}
		
		return country;
	}
}
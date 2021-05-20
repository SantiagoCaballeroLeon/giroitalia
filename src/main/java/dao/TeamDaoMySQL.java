package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Team;
import util.Conexion;

public class TeamDaoMySQL implements TeamDao{
	private Conexion conexion;
	
	private static final String INSERT_TEAM_SQL = "INSERT INTO team (name, country) VALUES (?,?);";
	private static final String DELETE_TEAM_SQL = "DELETE FROM team WHERE id = ?;";
	private static final String UPDATE_TEAM_SQL = "UPDATE team SET name = ?, country = ? WHERE id = ?;";
	private static final String SELECT_TEAM_BY_ID = "SELECT * FROM team WHERE id = ?;";
	private static final String SELECT_ALL_TEAMS = "SELECT * FROM team;";
	
	
	public TeamDaoMySQL() {
		this.conexion = Conexion.getConexion();
	}
	
	public void insert (Team team) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_TEAM_SQL);
			preparedStatement.setString(1, team.getName());
			preparedStatement.setString(2, team.getCountry());
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
	
	public void update (Team team) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(UPDATE_TEAM_SQL);
			preparedStatement.setString(1, team.getName());
			preparedStatement.setString(2, team.getCountry());
			preparedStatement.setInt(4, team.getId());
			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	public List<Team> selectAll() {
		List <Team> teams = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_TEAMS);
			ResultSet rs =  conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String country = rs.getString("country");
				teams.add(new Team(id, name, country));
			}
		} catch (SQLException e) {
			
		}
		
		return teams;
	}
	
	public Team select(int id) {
		Team team = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_TEAM_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs =  conexion.query();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String country = rs.getString("country");
				team = new Team(id, name, country);
			}
		} catch (SQLException e) {
			
		}
		
		return team;
	}
}

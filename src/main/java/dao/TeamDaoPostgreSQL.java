package dao;

import java.sql.SQLException;
import java.util.List;

import model.Team;
import util.Conexion;
import util.ConexionPostgreSQL;

public class TeamDaoPostgreSQL implements TeamDao {
	
	private ConexionPostgreSQL conexion;
	
	private static final String INSERT_TEAM_SQL = "INSERT INTO country (name) VALUES (?,?);";
	private static final String DELETE_TEAM_SQL = "DELETE FROM country WHERE id = ?;";
	private static final String UPDATE_TEAM_SQL = "UPDATE country SET name = ?, country = ? WHERE id = ?;";
	private static final String SELECT_TEAM_BY_ID = "SELECT * FROM country WHERE id = ?;";
	private static final String SELECT_ALL_TEAMS = "SELECT * FROM country;";

	@Override
	public void insert(Team team) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Team select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Team team) throws SQLException {
		// TODO Auto-generated method stub

	}

}

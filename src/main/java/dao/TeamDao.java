package dao;

import java.sql.SQLException;
import java.util.List;

import model.Team;

public interface TeamDao {
	public void insert(Team team) throws SQLException;
	public Team select(int id);
	public List < Team > selectAll();
	public void delete(int id) throws SQLException;
	public void update(Team team) throws SQLException;
}

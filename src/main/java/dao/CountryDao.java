package dao;

import java.sql.SQLException;
import java.util.List;

import model.Country;

public interface CountryDao {
	public void insert(Country country) throws SQLException;
	public Country select(int id);
	public List < Country > selectAll();
	public void delete(int id) throws SQLException;
	public void update(Country country) throws SQLException;
}

package dao;

public class TeamDaoFactory {
	public static TeamDao getTeamDao(String type) {
		switch(type) {
		case "mysql":
			return new TeamDaoMySQL();
		case "postgresql":
			return new TeamDaoPostgreSQL();
		default:
			return new TeamDaoMySQL();
		}
	}
}

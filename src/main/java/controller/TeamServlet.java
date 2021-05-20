package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeamDaoMySQL;
import dao.TeamDao;
import model.Team;


/**
 * Servlet implementation class TeamServlet
 */
@WebServlet("/TeamServlet")
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TeamDao teamDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
    	this.teamDao = new TeamDaoMySQL();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
		
			switch(action) {
				case "/new":
					showNewForm(request, response);
					break;
				case "/insert":
					insertarEquipo(request, response);
					break;
				case "/delete":
					eliminarEquipo(request, response);
					break;
				case "/edit":
					showEditForm(request, response);
					break;
				case "/update":
					editarEquipo(request, response);
					break;
				default:
					listEquipos(request, response);
					break;
			}
			
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		
	}
    
    private void listEquipos(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		List <Team> listUsuarios = teamDao.selectAll();
		request.setAttribute("listTeam", listUsuarios);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("teamlist.jsp");
		// Redireccionar
		dispatcher.forward(request, response);
		
	}
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Team teamActual = teamDao.select(id);
		request.setAttribute("team", teamActual);
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("team.jsp");
		// Redireccionar
		dispatcher.forward(request, response);
	}
    
    private void eliminarEquipo(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		teamDao.delete(id);
		response.sendRedirect("list");
	}
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("team.jsp");
		dispatcher.forward(request, response);
	}

	
	private void insertarEquipo(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		
		Team team = new Team(name, country);
		teamDao.insert(team);
		response.sendRedirect("list");
	}
	
	private void editarEquipo(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		
		Team team = new Team(id, name, country);
		teamDao.update(team);
		response.sendRedirect("list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

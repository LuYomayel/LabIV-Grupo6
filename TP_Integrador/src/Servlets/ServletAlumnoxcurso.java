package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImpl.AlumnoDaoImpl;
import DaoImpl.AlumnoxcursoDaoImpl;
import DaoImpl.CursoDaoImpl;
import DaoImpl.DocenteDaoImpl;
import DaoImpl.LocalidadDaoImpl;
import DaoImpl.PaisDaoImpl;
import DaoImpl.ProvinciaDaoImpl;
import Entidad.Alumno;
import Entidad.Alumnoxcurso;
import Entidad.Curso;
import Entidad.Docente;
import Entidad.Localidad;
import Entidad.Pais;
import Entidad.Provincia;

@WebServlet("/ServletAlumno")
public class ServletAlumnoxcurso extends HttpServlet{
	private static final long serialVersionUID= 1L;
	
	public ServletAlumnoxcurso() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Parametro Param de NotasAlumnos.jsp
		if(request.getParameter("Param")!=null) {
			AlumnoxcursoDaoImpl dao = new AlumnoxcursoDaoImpl();
			ArrayList<Alumnoxcurso> lista = dao.ListarAlumnosxcurso();
			request.setAttribute("listaAxc", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/NotasAlumnos.jsp");
			rd.forward(request, response);
		}
		
		
		//Parametro Agregar de NotasAlumnos.jsp
		if(request.getParameter("Agregar")!=null) {
			int id = 1000;
			AlumnoxcursoDaoImpl dao = new  AlumnoxcursoDaoImpl();
			ArrayList<Alumnoxcurso> lista= dao.ListarAlumnosxcurso();
			request.setAttribute("listaA", lista);
			
			if(lista != null) {
				for(Alumnoxcurso alumnoxcurso : lista) {
					if(alumnoxcurso.getId()>id) id=alumnoxcurso.getId();
				}
			}
			id++;
			
			request.setAttribute("id", id);
			
			CursoDaoImpl cDao = new CursoDaoImpl();
			ArrayList<Curso> listaCurso =cDao.ListarCursos();
			AlumnoDaoImpl aDao = new AlumnoDaoImpl();
			ArrayList<Alumno> listaAlumno =aDao.ListarAlumnos();
			request.setAttribute("ListarCursos", listaCurso);
			request.setAttribute("ListarAlumnos", listaAlumno);
			
			/*REDIRIGE AL JSP : /NotasAlumnos.jsp Este agrega notas y las lista
			 * Fijense si lo quieren hacer diferente*/
			RequestDispatcher rd = request.getRequestDispatcher("/NotasAlumnos.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
}

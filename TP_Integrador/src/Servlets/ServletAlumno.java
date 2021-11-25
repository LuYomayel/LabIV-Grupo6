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
import Entidad.Alumno;

/**
 * Servlet implementation class ServletAlumno
 */
@WebServlet("/ServletAlumno")
public class ServletAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Agregar Alumno
		
		
		if(request.getParameter("btnAgregar")!=null){
			if(request.getParameter("txtDni")!=null && request.getParameter("txtNombre")!=null && request.getParameter("txtApellido")!=null && request.getParameter("txtFecha")!=null&& request.getParameter("txtDireccion")!=null&& request.getParameter("txtNacionalidad")!=null&& request.getParameter("txtProvincia")!=null && request.getParameter("txtEmail")!=null&& request.getParameter("txtTelefono")!=null) {
				int filas =0;
				Alumno alu = new Alumno();
				
				alu.setLegajo(alu.devuelveProximoLegajo());
				alu.setDni(request.getParameter("txtDni"));
				alu.setNombre(request.getParameter("txtNombre"));
				alu.setApellido(request.getParameter("txtApellido"));
				alu.setFechanacimiento(request.getParameter("txtFecha"));
				alu.setDireccion(request.getParameter("txtDireccion"));
				alu.setNacionalidad(request.getParameter("txtNacionalidad"));
				alu.setProvincia(request.getParameter("txtProvincia"));
				
				alu.setEmail(request.getParameter("txtEmail"));
				alu.setTelefono(request.getParameter("txtTelefono"));
				
				AlumnoDaoImpl dao = new AlumnoDaoImpl();
				filas = dao.agregarAlumno(alu);
						
				request.setAttribute("cantFilas", filas);
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				
			}
			else {
				RequestDispatcher rd= request.getRequestDispatcher("/AgregarAlumnos.jsp");
				rd.forward(request, response);
			}
			
			}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnListarAlumnos")!=null) {
			AlumnoDaoImpl dao = new AlumnoDaoImpl();
			ArrayList<Alumno> lista= dao.ListarAlumnos();
			request.setAttribute("listita", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/ListarAlumnos.jsp");
			rd.forward(request, response);
	}
		
		if(request.getParameter("btnEliminar")!=null) {
			int id= Integer.parseInt(request.getParameter("legajo").toString());
			AlumnoDaoImpl dao =new AlumnoDaoImpl();
			dao.eliminarAlumno(id);
			
			ArrayList<Alumno> lista= dao.ListarAlumnos();
			request.setAttribute("listita", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/");
			rd.forward(request, response);
		}
	}

}
